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
import com.josiah.doctorapp.helper.FileHelper;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataService {
  private static final int BATCH_SIZE = 1000;
  private static final String QUESTION_MARK = "?";
  private static final String COLUMNS = "{COLUMNS}";
  private static final String VALUES = "{VALUES}";
  private static final String INSERT_STATEMENT = String.format("INSERT INTO general_data(%s) VALUES (%s)", COLUMNS, VALUES);

  private final DownloadHelper downloadHelper;
  private final MetastoreApi metastoreApi;
  private final CmsProperties properties;
  private final DataSource dataSource;

  @Async
  public void loadData() {
    MetastoreResponse metaResponse = metastoreApi.getMetastoreItems(
        MetastoreRequest.builder()
            .id(properties.getMetastoreId())
            .build());

    String downloadUrl = metaResponse.getDistribution().get(0).getData().getDownloadURL();

    try {
      InputStream stream = downloadHelper.streamFile(downloadUrl);

      process(stream);
    } catch (IOException | SQLException e) {
      log.error("Failed to get CSV: {}", downloadUrl, e);
    }
  }

  private void process(InputStream stream) throws SQLException {
    LocalDateTime start = LocalDateTime.now();
    try (InputStreamReader sReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        Connection conn = dataSource.getConnection();
        CSVReader reader = new CSVReader(sReader)) {

      List<String> headers = getHeaders(reader.readNext());
      processBatch(headers, conn, reader);
    } catch (IOException | SQLException | CsvValidationException e) {
      e.printStackTrace();
    } finally {
      LocalDateTime end = LocalDateTime.now();
      log.info("took {}", ChronoUnit.SECONDS.between(start, end));
    }
  }

  private void processBatch(List<String> headers, Connection conn, CSVReader reader) throws CsvValidationException, IOException, SQLException {
    long lines = 0;
    String[] data;
    try (PreparedStatement statement = getStatement(conn, headers)) {
      while ((data = reader.readNext()) != null) {
        try {
          for (int i = 1; i <= data.length; i++) {
            statement.setObject(i, data[i - 1]);
          }
          statement.addBatch();

          if (++lines % BATCH_SIZE == 0) {
            log.info("Execute batch: {}", lines);
            statement.executeBatch();
          }
        } catch (SQLException e) {
          log.error("Failed to execute batch {}", lines, e);
        }
      }

      statement.executeBatch();
    }
  }

  private PreparedStatement getStatement(Connection conn, List<String> headers) throws SQLException {
    String questionMarks = headers.stream()
        .map(header -> QUESTION_MARK)
        .collect(Collectors.joining(","));

    String statement = INSERT_STATEMENT.replace(COLUMNS, String.join(",", headers))
        .replace(VALUES, questionMarks);

    return conn.prepareStatement(statement);
  }

  private List<String> getHeaders(String[] headers) {
    return Arrays.stream(headers)
        .map(header ->
            header.equals("Name_of_Third_Party_Entity_Receiving_Payment_or_Transfer_of_Value")
                ? "name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc"
                : header)
        .collect(Collectors.toList());
  }
}
