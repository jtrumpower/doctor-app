package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.data.GeneralStatementCreator;
import com.josiah.doctorapp.data.rowmapper.GeneralRowMapper;
import com.josiah.doctorapp.service.DownloadService;
import com.josiah.doctorapp.service.model.GeneralRow;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DownloadServiceImpl implements DownloadService {

  private final JdbcTemplate jdbcTemplate;

  public void printResults(SearchRequestJdbc searchRequestJdbc, PrintWriter writer) {
    StatefulBeanToCsv<GeneralRow> sbc = new StatefulBeanToCsvBuilder<GeneralRow>(writer).build();
    Stream<GeneralRow> entries = jdbcTemplate.queryForStream(
        GeneralStatementCreator.builder()
            .request(searchRequestJdbc)
            .oneByOne(true)
            .build(),
        new GeneralRowMapper());

    entries.forEach(row -> {
      try {
        sbc.write(row);
      } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
        log.error("CSV Write error", e);
      }
    });
  }
}
