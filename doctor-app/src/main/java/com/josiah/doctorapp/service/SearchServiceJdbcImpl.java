package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.data.GeneralStatementCreator;
import com.josiah.doctorapp.data.StatementEnum;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.service.enums.RowTypeEnum;
import com.josiah.doctorapp.service.mapper.SortMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("searchServiceJdbc")
public class SearchServiceJdbcImpl implements SearchService<SearchRequestJdbc> {
  private static final String SELECT_COUNT_STATEMENT = "SELECT COUNT(*) FROM general_data";
  private static final String ORDER_BY_STATEMENT = " ORDER BY %s";
  private static final String LIMIT_STATEMENT = " LIMIT %s OFFSET %s";

  private final SortMapper sortMapper;
  private final JdbcTemplate jdbcTemplate;
  private final DataSource dataSource;

  public SearchResponse search(SearchRequestJdbc params) {

    Page<GeneralRow> pageResults = getResults(params);

    return SearchResponse.builder()
        .totalPages(pageResults.getTotalPages())
        .totalResults(pageResults.getTotalElements())
        .results(pageResults.getContent())
        .build();
  }

  private Page<GeneralRow> getResults(SearchRequestJdbc params) {
    Pageable pageable = PageRequest.of(params.getPage(), params.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(params.getSorting())));

    List<GeneralRow> rows = jdbcTemplate.query(
        new GeneralStatementCreator(params, sortMapper),
        new com.josiah.doctorapp.data.rowmapper.GeneralRowMapper());
    Integer count = getCount(params, pageable);

    return new PageImpl<>(rows, pageable, count);
  }

  private Integer getCount(SearchRequestJdbc params, Pageable pageable) {
    StringBuilder sBuilder = new StringBuilder(SELECT_COUNT_STATEMENT);
    getCountWhere(params, pageable).ifPresent(sBuilder::append);
    getCountOrder(pageable).ifPresent(sBuilder::append);
    sBuilder.append(String.format(LIMIT_STATEMENT, pageable.getPageSize(), pageable.getOffset()));

    return jdbcTemplate.queryForObject(sBuilder.toString(), Integer.class);
  }


  private Optional<String> getCountWhere(SearchRequestJdbc params, Pageable pageable) {
    if (!StringUtils.isEmpty(params.getColumns()) && !StringUtils.isEmpty(params.getValue())) {
      return Optional.of(Arrays.stream(params.getColumns().split("\\|"))
          .map(val -> val + " like %" + params.getValue() + "%")
          .collect(Collectors.joining(" or ")));
    }

    return Optional.empty();
  }

  private Optional<String> getCountOrder(Pageable pageable) {
    if (pageable.getSort().isSorted()) {
      return Optional.of(
          String.format(ORDER_BY_STATEMENT,
              pageable.getSort()
                  .stream()
                  .map(order ->
                      String.format("%s %s", order.getProperty(), order.getDirection()))
                  .collect(Collectors.joining(","))));
    }

    return Optional.empty();
  }
}
