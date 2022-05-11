package com.josiah.doctorapp.data;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.data.builder.GeneralDataStatementBuilder;
import com.josiah.doctorapp.service.mapper.SortMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.PreparedStatementCreator;

@RequiredArgsConstructor
public class GeneralStatementCreator implements PreparedStatementCreator {
  private final SearchRequestJdbc request;
  private final SortMapper sortMapper;

  @Override
  public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(request.getSorting())));

    GeneralDataStatementBuilder builder = new GeneralDataStatementBuilder();

    Arrays.stream(request.getColumns().split("\\|"))
        .forEach(column -> builder.where(column, request.getValue()));

    return builder
        .pageable(pageable)
        .withConnection(con)
        .build();
  }
}
