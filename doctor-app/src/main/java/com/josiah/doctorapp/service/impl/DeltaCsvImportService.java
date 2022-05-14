package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.api.constants.Constants.Column;
import com.josiah.doctorapp.service.CsvImportService;
import com.opencsv.CSVParser;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeltaCsvImportService extends CsvImportService {

  private final JdbcTemplate jdbcTemplate;

  public DeltaCsvImportService(DataSource dataSource, CSVParser csvParser, JdbcTemplate jdbcTemplate) {
    super(dataSource, csvParser);
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  protected void addBatch(PreparedStatement statement, String[] data, List<String> headers)
      throws SQLException {
    if (!data[0].equals("UNCHANGED")) {
      deleteIfExists(data, headers);
      for (int i = 1; i <= data.length; i++) {
        statement.setObject(i, data[i - 1]);
      }
      statement.addBatch();
    }
  }

  private void deleteIfExists(String[] data, List<String> headers) {
    try {
      jdbcTemplate.execute("delete from general_data where record_id = " + Long.parseLong(data[findIndex(headers, Column.RECORD_ID)]));
    } catch (NumberFormatException | IndexOutOfBoundsException e) {
      log.error(String.format("Couldn't delete record %s", Arrays.toString(data)));
    }
  }

  private int findIndex(List<String> list, String search) {
    int index = -1;

    for (int i = 0; i < list.size(); i++) {
      if (search.equalsIgnoreCase(list.get(i))) {
        index = i;
        break;
      }
    }

    return index;
  }

  @Override
  protected boolean shouldTruncate() {
    return false;
  }
}
