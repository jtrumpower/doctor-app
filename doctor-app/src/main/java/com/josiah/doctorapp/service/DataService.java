package com.josiah.doctorapp.service;

import com.josiah.doctorapp.api.MetastoreApi;
import com.josiah.doctorapp.api.model.request.MetastoreRequest;
import com.josiah.doctorapp.api.model.response.Distribution;
import com.josiah.doctorapp.api.model.response.DistributionData;
import com.josiah.doctorapp.api.model.response.MetastoreResponse;
import com.josiah.doctorapp.config.properties.CmsProperties;
import com.josiah.doctorapp.helper.DownloadHelper;
import com.josiah.doctorapp.helper.FileHelper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileInputStream;
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
import java.util.Optional;
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
  private static final String FILE_PATH = "./data.csv";

  private final DownloadHelper downloadHelper;
  private final MetastoreApi metastoreApi;
  private final FileHelper fileHelper;
  private final CmsProperties properties;
  private final DataSource dataSource;

  public File downloadFile() throws IOException {
    MetastoreResponse metaResponse = metastoreApi.getMetastoreItems(
        MetastoreRequest.builder()
            .id(properties.getMetastoreId())
            .build());

    InputStream stream = downloadHelper.streamFile(downloadHelper.getDownloadUrl(metaResponse));
    return fileHelper.writeFile(stream, FILE_PATH);
  }

  @Async
  public void loadData() {
    try {
      FileInputStream inputStream = fileHelper.getFileInputStream(downloadFile());

      process(inputStream);
    } catch (IOException | SQLException e) {
      log.error("Failed to process CSV", e);
    }
  }

  private void process(InputStream stream) throws SQLException {
    LocalDateTime start = LocalDateTime.now();
    try (InputStreamReader sReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        Connection conn = dataSource.getConnection();
        CSVReader reader = new CSVReader(sReader)) {

      List<String> headers = getHeaders(reader.readNext());

      try (PreparedStatement statement = getStatement(conn, headers)) {
        processBatch(statement, reader);
      }
    } catch (IOException | SQLException | CsvValidationException e) {
      e.printStackTrace();
    } finally {
      LocalDateTime end = LocalDateTime.now();
      log.info("took {}", ChronoUnit.SECONDS.between(start, end));
    }
  }

  private void processBatch(PreparedStatement statement, CSVReader reader) throws CsvValidationException, IOException, SQLException {
    long lines = 0;
    String[] data;
    // CSV has validation error around line 8.5M.
    // To avoid error short circuit surround read with try in indefinite loop
    for(;;) {
      try {
        data = reader.readNext();
        if (data != null && lines < 50000) {
          for (int i = 1; i <= data.length; i++) {
            statement.setObject(i, data[i - 1]);
          }
          statement.addBatch();

          if (++lines % BATCH_SIZE == 0) {
            log.info("Execute batch: {}", lines);
            statement.executeBatch();
          }
        } else {
          break;
        }
      } catch(CsvException | SQLException e){
        log.error("Failed to execute batch {}", lines, e);
      }
    }
    statement.executeBatch();
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
