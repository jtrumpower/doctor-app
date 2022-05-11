package com.josiah.doctorapp.data.builder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GeneralDataStatementBuilder {
  private static final String SELECT_STATEMENT = "SELECT * FROM general_data";
  private static final String SELECT_COUNT_STATEMENT = "SELECT COUNT(*) FROM general_data";
  private static final String ORDER_BY_STATEMENT = " ORDER BY ";
  private static final String LIMIT_STATEMENT = " LIMIT %s OFFSET %s";

  private final Map<String, String> where = new HashMap<>();
  private Pageable pageable;
  public Connection connection;

  public GeneralDataStatementBuilder where(String column, String value) {
    where.put(column, value);

    return this;
  }

  public GeneralDataStatementBuilder pageable(Pageable pageable) {
    this.pageable = pageable;

    return this;
  }

  public GeneralDataStatementBuilder withConnection(Connection connection) {
    this.connection = connection;

    return this;
  }

  public PreparedStatement build() throws SQLException {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(SELECT_STATEMENT);

    if (!where.isEmpty()) {
      sBuilder.append(" where ");
      sBuilder.append(
          where.keySet()
              .stream()
              .map((key) -> String.format("%s like ?", key))
              .collect(Collectors.joining(" or ")));
    }
    if (pageable != null) {
      if (pageable.getSort().isSorted()) {
        sBuilder.append(ORDER_BY_STATEMENT);
        sBuilder.append(
            pageable.getSort()
                .stream()
                .map(order ->
                    String.format("%s %s", order.getProperty(), order.getDirection().name()))
                .collect(Collectors.joining(",")));
      }
      sBuilder.append(String.format(LIMIT_STATEMENT, pageable.getPageSize(), pageable.getOffset()));
    }
    PreparedStatement statement = connection.prepareStatement(sBuilder.toString());

    if (!where.isEmpty()) {
      for (int i = 0; i < where.values().size(); i++) {
        statement.setObject(i+1, String.format("%%%s%%", where.values().toArray()[i]));
      }
    }

    return statement;
  }
}
