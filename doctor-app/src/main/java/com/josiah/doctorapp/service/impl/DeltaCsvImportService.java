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
  protected boolean addBatch(PreparedStatement statement, List<String> data, List<String> headers)
      throws SQLException {
    if (!data.get(findIndex(headers, Column.CHANGE_TYPE)).equals("UNCHANGED")) {
      deleteIfExists(data, headers);
      addInsertToBatch(statement, data);

      return true;
    } else if(!exists(data, headers)) {
      addInsertToBatch(statement, data);

      return true;
    }

    return false;
  }

  private boolean exists(List<String> data, List<String> headers) {
    Integer exists = jdbcTemplate.queryForObject(
        "select exists(select record_id from general_data where record_id = ?)",
        Integer.class,
        Long.parseLong(data.get(findIndex(headers, Column.RECORD_ID))));

    return exists != null && exists > 0;
  }

  private void deleteIfExists(List<String> data, List<String> headers) {
    try {
      jdbcTemplate.execute("delete from general_data where record_id = " + Long.parseLong(data.get(findIndex(headers, Column.RECORD_ID))));
    } catch (NumberFormatException | IndexOutOfBoundsException e) {
      log.error(String.format("Couldn't delete record %s", data));
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
