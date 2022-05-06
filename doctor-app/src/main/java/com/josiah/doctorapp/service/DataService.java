package com.josiah.doctorapp.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.josiah.doctorapp.api.DatastoreApi;
import com.josiah.doctorapp.api.MetastoreApi;
import com.josiah.doctorapp.api.model.request.DatastoreRequest;
import com.josiah.doctorapp.api.model.request.MetastoreRequest;
import com.josiah.doctorapp.api.model.response.MetastoreResponse;
import com.josiah.doctorapp.config.properties.CmsProperties;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.helper.CsvHelper;
import com.josiah.doctorapp.helper.DownloadHelper;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.DataTruncation;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataService {

  private final GeneralRepository repository;
  private final DownloadHelper downloadHelper;
  private final MetastoreApi metastoreApi;
  private final CsvHelper csvHelper;
  private final CmsProperties properties;
  private final GeneralRowMapper mapper;
  private final EntityManager entityManager;

  public void loadData() {
    MetastoreResponse metaResponse = metastoreApi.getMetastoreItems(
        MetastoreRequest.builder()
            .id(properties.getMetastoreId())
            .build());

    String downloadUrl = metaResponse.getDistribution().get(0).getData().getDownloadURL();

    try {
      InputStream stream = downloadHelper.streamFile(downloadUrl);

      process(stream);
    } catch (IOException e) {
      log.error("Failed to get CSV: {}", downloadUrl, e);
    }
  }

  private void process(InputStream stream) {
    try (InputStreamReader sReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(sReader)) {
      String line = buffer.readLine();
      List<GeneralEntity> entities = new ArrayList<>();
      long lines = 0;
      LocalDateTime start = LocalDateTime.now();

      while ((line = buffer.readLine()) != null && lines < 50000) {
        GeneralRow generalRow = csvHelper.readFromString(line, GeneralRow.class);
        entities.add(mapper.mapGeneralRowToEntity(generalRow));

        if (entities.size() == 100) {
          log.info("Saving entities, current line {}", lines);
          saveAll(entities);
          entities = new ArrayList<>();
        }
        lines++;
      }

      LocalDateTime end = LocalDateTime.now();
      log.info("took {}", ChronoUnit.SECONDS.between(start, end));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Transactional
  public void saveAll(List<GeneralEntity> entities) {
    try {
      repository.saveAll(entities);
      entities.forEach(entityManager::detach);
    } catch (Exception e) {
      log.error("An error occurred when inserting batch: {}", entities, e);
    }
  }
}
