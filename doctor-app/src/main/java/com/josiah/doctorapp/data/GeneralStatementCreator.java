package com.josiah.doctorapp.data;

import static com.josiah.doctorapp.api.constants.Constants.WHITELIST;

import com.josiah.doctorapp.api.constants.Constants.Column;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.data.builder.GeneralDataStatementBuilder;
import com.josiah.doctorapp.service.mapper.SortMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.PreparedStatementCreator;

@Builder
@RequiredArgsConstructor
public class GeneralStatementCreator implements PreparedStatementCreator {
  private final SearchRequestJdbc request;
  private final Pageable pageable;
  private final boolean distinct;
  private final boolean count;
  private final boolean like;
  private final boolean oneByOne;

  @Override
  public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

    GeneralDataStatementBuilder builder = new GeneralDataStatementBuilder();

    if (!StringUtils.isEmpty(request.getColumns()) && !StringUtils.isEmpty(request.getValue())) {
      Arrays.stream(request.getColumns().split("\\|"))
          .filter(WHITELIST::contains)
          .forEach(column -> builder.where(column, request.getValue()));
    }

    return builder
        .distinct(distinct)
        .count(count)
        .like(like)
        .pageable(pageable)
        .oneByOne(oneByOne)
        .withConnection(con)
        .build();
  }
}
