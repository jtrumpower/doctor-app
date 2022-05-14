package com.josiah.doctorapp.service;

import com.josiah.doctorapp.job.model.LoadDataParam;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
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

@Slf4j
@RequiredArgsConstructor
public abstract class CsvImportService {
  private static final int BATCH_SIZE = 1000;
  private static final String QUESTION_MARK = "?";
  private static final String COLUMNS = "{COLUMNS}";
  private static final String VALUES = "{VALUES}";
  private static final String INSERT_STATEMENT = String.format("INSERT INTO general_data(%s) VALUES (%s)", COLUMNS, VALUES);

  private final DataSource dataSource;
  private final CSVParser csvParser;

  protected abstract void addBatch(PreparedStatement statement, String[] data, List<String> headers)
      throws SQLException;
  protected abstract boolean shouldTruncate();

  public void stream(InputStream stream, LoadDataParam param) throws SQLException {
    LocalDateTime start = LocalDateTime.now();
    Connection conn = dataSource.getConnection();
    InputStreamReader streamReader = new InputStreamReader(stream);
    BufferedReader bufferedReader = new BufferedReader(streamReader);

    try (streamReader;bufferedReader;conn) {
      List<String> headers = getHeaders(bufferedReader.readLine());
      conn.setAutoCommit(false);

      try (PreparedStatement statement = getStatement(conn, headers)) {
        if (shouldTruncate()) {
          statement.execute("truncate general_data");
        }

        loadData(statement, conn, bufferedReader, param, headers);

        conn.commit();
        conn.setAutoCommit(true);
      } catch (Exception e) {
        conn.rollback();
        throw e;
      }
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    } finally {
      log.info("took {}", ChronoUnit.SECONDS.between(start,  LocalDateTime.now()));
    }
  }

  private void loadData(PreparedStatement statement, Connection conn,
      BufferedReader reader, LoadDataParam param, List<String> headers) throws SQLException {
    String[] data;
    // CSV has validation error around line 8.5M.
    // To avoid error short circuit surround read with try in indefinite loop
    CSVParser csvParser = new CSVParser();
    for(int lines = 1;;lines++) {
      try {
        data = csvParser.parseLine(reader.readLine());
        if (data != null) {

          addBatch(statement, data, headers);

          if (lines % BATCH_SIZE == 0) {
            log.info("Execute batch: {}", lines);
            statement.executeBatch();
            conn.commit();
          }

          if (param.getNumRows() > 0 && param.getNumRows() == lines) {
            break;
          }
        } else {
          break;
        }
      } catch(SQLException | IOException e){
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

  private List<String> getHeaders(String headers) throws IOException {
    return Arrays.stream(csvParser.parseLine(headers))
        .map(header ->
            header.equals("Name_of_Third_Party_Entity_Receiving_Payment_or_Transfer_of_Value")
                ? "name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc"
                : header)
        .collect(Collectors.toList());
  }
}
