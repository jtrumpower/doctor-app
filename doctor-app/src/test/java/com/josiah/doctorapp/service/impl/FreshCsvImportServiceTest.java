package com.josiah.doctorapp.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import com.josiah.doctorapp.api.constants.Constants.Column;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.opencsv.CSVParser;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

@ExtendWith(MockitoExtension.class)
class FreshCsvImportServiceTest {
  private static final String VAL_1 = "val 1";
  private static final String VAL_2 = "val 2";
  private static final String VAL_3 = "val 3";
  private static final String VAL_4 = "val 4";
  private static final String INSERT_STATEMENT = "INSERT INTO general_data(%s) VALUES (%s)";
  private static final String CSV_STRING = String.format("%s,%s\n%s,%s\n%s,%s", Column.CHANGE_TYPE, Column.PHYSICIAN_FIRST_NAME, VAL_1, VAL_2, VAL_3, VAL_4);
  private static final String CSV_UNWANTED_STRING = String.format("%s,%s,%s\n%s,%s,%s\n%s,%s,%s", Column.CHANGE_TYPE, Column.PHYSICIAN_FIRST_NAME, "Bad Column", VAL_1, VAL_2, "some val", VAL_3, VAL_4, "some val");


  @Mock
  private DataSource dataSource;
  @Mock
  private CSVParser csvParser;

  @InjectMocks
  private FreshCsvImportService sut;

  @Test
  @SneakyThrows
  void shouldAddData() {
    // given
    LoadDataParam param = LoadDataParam.builder()
        .newFile(false)
        .allRows(true)
        .build();

    Connection conn = mock(Connection.class);
    String[] inputs = CSV_STRING.split("\\n");
    PreparedStatement statement = mock(PreparedStatement.class);

    given(csvParser.parseLine(inputs[0])).willReturn(inputs[0].split(","));
    given(dataSource.getConnection()).willReturn(conn);
    given(conn.prepareStatement(String.format(INSERT_STATEMENT, inputs[0], "?,?"))).willReturn(statement);
    given(csvParser.parseLine(inputs[1])).willReturn(inputs[1].split(","));
    given(csvParser.parseLine(inputs[2])).willReturn(inputs[2].split(","));

    // when
    sut.importCsv(IOUtils.toInputStream(CSV_STRING, StandardCharsets.UTF_8), param);

    // then
    verify(statement, conn);
  }

  @Test
  @SneakyThrows
  void shouldStripUnwantedColumns() {
    // given
    String goodColumns = String.format("%s,%s", Column.CHANGE_TYPE, Column.PHYSICIAN_FIRST_NAME);
    LoadDataParam param = LoadDataParam.builder()
        .newFile(false)
        .allRows(true)
        .build();

    Connection conn = mock(Connection.class);
    String[] inputs = CSV_UNWANTED_STRING.split("\\n");
    PreparedStatement statement = mock(PreparedStatement.class);

    given(csvParser.parseLine(inputs[0])).willReturn(inputs[0].split(","));
    given(dataSource.getConnection()).willReturn(conn);
    given(conn.prepareStatement(String.format(INSERT_STATEMENT, goodColumns, "?,?"))).willReturn(statement);
    given(csvParser.parseLine(inputs[1])).willReturn(inputs[1].split(","));
    given(csvParser.parseLine(inputs[2])).willReturn(inputs[2].split(","));

    // when
    sut.importCsv(IOUtils.toInputStream(CSV_UNWANTED_STRING, StandardCharsets.UTF_8), param);

    // then
    verify(statement, conn);
  }

  @SneakyThrows
  private void verify(PreparedStatement statement, Connection conn) {
    then(statement).should().execute("truncate general_data");
    then(statement).should().setObject(1, VAL_1);
    then(statement).should().setObject(2, VAL_2);
    then(statement).should().setObject(1, VAL_3);
    then(statement).should().setObject(2, VAL_4);
    then(statement).should(times(2)).addBatch();
    then(statement).should().executeBatch();
    then(statement).should().close();
    then(conn).should().setAutoCommit(false);
    then(conn).should().commit();
    then(conn).should().setAutoCommit(true);
    then(conn).should().close();

    then(statement).shouldHaveNoMoreInteractions();
    then(conn).shouldHaveNoMoreInteractions();
  }
}
