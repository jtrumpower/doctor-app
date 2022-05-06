package com.josiah.doctorapp.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.josiah.doctorapp.api.DatastoreApi;
import com.josiah.doctorapp.api.model.request.DatastoreRequest;
import com.josiah.doctorapp.config.properties.CmsProperties;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.helper.CsvHelper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataService {

  private final GeneralRepository repository;
  private final DatastoreApi datastoreApi;
  private final CsvHelper csvHelper;
  private final CmsProperties properties;

  public void loadData() {
    InputStream stream = datastoreApi.queryDataById(
        DatastoreRequest.builder()
            .id(properties.getDatastoreId())
            .format("csv")
            .limit(20L)
            .build());

    store(stream);
  }

  public void store(InputStream stream) {
    try (InputStreamReader sReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(sReader)) {
      String line = buffer.readLine();

      while ((line = buffer.readLine()) != null) {
        GeneralRow generalEntity = csvHelper.readFromString(line, GeneralRow.class);
        log.info(generalEntity.toString());
      }
      buffer.lines().forEach(log::info);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
