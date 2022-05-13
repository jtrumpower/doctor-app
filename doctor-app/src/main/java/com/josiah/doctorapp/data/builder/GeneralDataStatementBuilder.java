package com.josiah.doctorapp.data.builder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Distinct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Slf4j
public class GeneralDataStatementBuilder {
  private static final String SELECT_STATEMENT = "SELECT * FROM general_data";
  private static final String SELECT_COUNT_STATEMENT = "SELECT count(*) FROM general_data";
  private static final String ORDER_BY_STATEMENT = " ORDER BY ";
  private static final String LIMIT_STATEMENT = " LIMIT %s OFFSET %s";

  private final Map<String, String> where = new HashMap<>();
  private Pageable pageable;
  public Connection connection;
  private boolean count;
  private boolean distinct;
  private boolean oneByOne;

  public GeneralDataStatementBuilder where(String column, String value) {
    where.put(column, value);

    return this;
  }

  public GeneralDataStatementBuilder pageable(Pageable pageable) {
    this.pageable = pageable;

    return this;
  }

  public GeneralDataStatementBuilder count(boolean count) {
    this.count = count;

    return this;
  }

  public GeneralDataStatementBuilder distinct(boolean distinct) {
    this.distinct = distinct;

    return this;
  }

  public GeneralDataStatementBuilder withConnection(Connection connection) {
    this.connection = connection;

    return this;
  }

  public GeneralDataStatementBuilder oneByOne(boolean oneByOne) {
    this.oneByOne = oneByOne;

    return this;
  }

  public PreparedStatement build() throws SQLException {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(buildSelect());

    if (!where.isEmpty()) {
      sBuilder.append(buildWhere());
    }
    if (pageable != null && !count) {
      if (pageable.getSort().isSorted()) {
        sBuilder.append(buildOrderBy());
      }
      sBuilder.append(String.format(LIMIT_STATEMENT, pageable.getPageSize(), pageable.getOffset()));
    }

    log.info(sBuilder.toString());
    PreparedStatement statement;
    if (oneByOne) {
      statement = connection.prepareStatement(sBuilder.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      statement.setFetchSize(Integer.MIN_VALUE);
    } else {
      statement = connection.prepareStatement(sBuilder.toString());
    }

    if (!where.isEmpty()) {
      for (int i = 0; i < where.values().size(); i++) {
        statement.setObject(i+1, String.format("%%%s%%", where.values().toArray()[i]));
      }
    }

    return statement;
  }

  private String buildOrderBy() {
    return ORDER_BY_STATEMENT +
        pageable.getSort()
            .stream()
            .map(order -> String.format("%s %s", order.getProperty(), order.getDirection().name()))
            .collect(Collectors.joining(","));
  }

  private String buildWhere() {
    return " where " +
        where.keySet()
            .stream()
            .map((key) -> String.format("%s like ?", key))
            .collect(Collectors.joining(" or "));
  }

  private String buildSelect() {
    String select;
    if (distinct) {
      select = String.format("select distinct %s from general_data", String.join(",", where.keySet()));
    } else if (count) {
      select = SELECT_COUNT_STATEMENT;
    } else {
      select = SELECT_STATEMENT;
    }

    return select;
  }
}
