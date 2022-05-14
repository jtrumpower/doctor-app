package com.josiah.doctorapp.service;

import static com.josiah.doctorapp.api.constants.Constants.WHITELIST;

import com.josiah.doctorapp.api.constants.Constants.Column;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.opencsv.CSVParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.apache.commons.lang3.StringUtils;

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

  protected abstract boolean addBatch(PreparedStatement statement, String[] data, List<String> headers)
      throws SQLException;
  protected abstract boolean shouldTruncate();

  public void importCsv(InputStream stream, LoadDataParam param) throws SQLException {
    LocalDateTime start = LocalDateTime.now();
    Connection conn = dataSource.getConnection();
    InputStreamReader streamReader = new InputStreamReader(stream);
    BufferedReader bufferedReader = new BufferedReader(streamReader);

    try (streamReader;bufferedReader;conn) {
      List<String> headers = filterWhitelisted(getHeaders(bufferedReader.readLine()));
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
    long numInBatch = 0;
    for(int lines = 1;;lines++) {
      try {
        data = csvParser.parseLine(reader.readLine());
        if (data != null) {

          if (addBatch(statement, data, headers)) {
            numInBatch++;
          }

          if (param.getNumRows() > 0 && param.getNumRows() == lines) {
            break;
          }

          postRowLoaded(conn, statement, numInBatch, lines);
        } else {
          break;
        }
      } catch(SQLException | IOException e){
        log.error("Failed to execute batch {}", lines, e);
      }
    }

    // clean up stragglers
    statement.executeBatch();
  }

  private void postRowLoaded(Connection conn, PreparedStatement statement, long numInBatch, long lines) throws SQLException {
    if (lines % BATCH_SIZE == 0) {
      log.info("Lines processed: {}", lines);
    }
    if (numInBatch > 0 && numInBatch % BATCH_SIZE == 0) {
      statement.executeBatch();
      conn.commit();
    }
  }

  protected void addInsertToBatch(PreparedStatement statement, String[] data) throws SQLException {
    for (int i = 1; i <= data.length; i++) {
      statement.setObject(i, data[i - 1]);
    }
    statement.addBatch();
  }

  private PreparedStatement getStatement(Connection conn, List<String> headers) throws SQLException {
    String questionMarks = headers
        .stream()
        .map(header -> QUESTION_MARK)
        .collect(Collectors.joining(","));

    String statement = INSERT_STATEMENT
        .replace(COLUMNS, StringUtils.join(headers, ","))
        .replace(VALUES, questionMarks);

    return conn.prepareStatement(statement);
  }

  private List<String> filterWhitelisted(List<String> headers) {
    return headers.stream()
        .filter(header -> WHITELIST.stream()
            .anyMatch(val -> val.equalsIgnoreCase(header)))
        .collect(Collectors.toList());
  }

  private List<String> getHeaders(String headers) throws IOException {
    return Arrays.stream(csvParser.parseLine(headers))
        .map(header ->
            header.equalsIgnoreCase(Column.NAME_OF_ENTITY_RECEIVING_PAYMENT_ACTUAL)
                ? Column.NAME_OF_ENTITY_RECEIVING_PAYMENT
                : header)
        .collect(Collectors.toList());
  }
}
