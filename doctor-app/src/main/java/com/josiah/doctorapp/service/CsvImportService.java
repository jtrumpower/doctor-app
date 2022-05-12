package com.josiah.doctorapp.service;

import com.josiah.doctorapp.job.model.LoadDataParam;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
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
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CsvImportService {
  private static final int BATCH_SIZE = 1000;
  private static final String QUESTION_MARK = "?";
  private static final String COLUMNS = "{COLUMNS}";
  private static final String VALUES = "{VALUES}";
  private static final String INSERT_STATEMENT = String.format("INSERT INTO general_data(%s) VALUES (%s)", COLUMNS, VALUES);

  private final DataSource dataSource;

  public void stream(InputStream stream, LoadDataParam param) throws SQLException {
    LocalDateTime start = LocalDateTime.now();
    Connection conn = dataSource.getConnection();
    InputStreamReader sReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
    CSVReader reader = new CSVReader(sReader);

    try (sReader;conn;reader) {
      List<String> headers = getHeaders(reader.readNext());

      try (PreparedStatement statement = getStatement(conn, headers)) {
        conn.createStatement().execute("truncate general_data");
        loadData(statement, reader, param);
      }
    } catch (IOException | SQLException | CsvValidationException e) {
      e.printStackTrace();
    } finally {
      log.info("took {}", ChronoUnit.SECONDS.between(start,  LocalDateTime.now()));
    }
  }

  private void loadData(PreparedStatement statement, CSVReader reader, LoadDataParam param) throws CsvValidationException, IOException, SQLException {
    String[] data;
    // CSV has validation error around line 8.5M.
    // To avoid error short circuit surround read with try in indefinite loop
    for(int lines = 1;;lines++) {
      try {
        data = reader.readNext();
        if (data != null) {

          addBatchAndExecute(statement, data, lines);

          if (param.getNumRows() > 0 && param.getNumRows() == lines) {
            break;
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

  private void addBatchAndExecute(PreparedStatement statement, String[] data, long lines)
      throws SQLException {
    for (int i = 1; i <= data.length; i++) {
      statement.setObject(i, data[i - 1]);
    }
    statement.addBatch();

    if (++lines % BATCH_SIZE == 0) {
      log.info("Execute batch: {}", lines);
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
