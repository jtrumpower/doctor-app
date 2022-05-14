package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.service.CsvImportService;
import com.opencsv.CSVParser;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;

@Service
public class FreshCsvImportService extends CsvImportService {

  public FreshCsvImportService(DataSource dataSource, CSVParser csvParser) {
    super(dataSource, csvParser);
  }

  @Override
  protected boolean addBatch(PreparedStatement statement, String[] data, List<String> headers) throws SQLException {
    addInsertToBatch(statement, data);

    return true;
  }

  @Override
  protected boolean shouldTruncate() {
    return true;
  }
}
