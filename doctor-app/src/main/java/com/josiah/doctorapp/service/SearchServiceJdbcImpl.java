package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.service.enums.RowTypeEnum;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import com.josiah.doctorapp.service.mapper.SortMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
  private static final String SELECT_STATEMENT = "SELECT * FROM general_data where %s";
  private static final String SELECT_COUNT_STATEMENT = "SELECT COUNT(*) FROM general_data where %s";
  private static final String ORDER_BY_STATEMENT = " ORDER BY %s";
  private static final String LIMIT_STATEMENT = " LIMIT %s OFFSET %s";

  private final GeneralRowMapper rowMapper;
  private final SortMapper sortMapper;
  private final JdbcTemplate jdbcTemplate;

  public SearchResponse search(SearchRequestJdbc params) {

    Page<GeneralEntity> pageResults = getResults(params);

    return SearchResponse.builder()
        .totalPages(pageResults.getTotalPages())
        .totalResults(pageResults.getTotalElements())
        .results(pageResults.getContent()
            .stream()
            .map(rowMapper::mapGeneralRowToEntity)
            .collect(Collectors.toList()))
        .build();
  }

  private Page<GeneralEntity> getResults(SearchRequestJdbc params) {
    Pageable pageable = PageRequest.of(params.getPage(), params.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(params.getSorting())));

    String where = Arrays.stream(params.getColumns().split("\\|"))
        .map(val -> val + " like %" + params.getValue() + "%")
        .collect(Collectors.joining(" or "));
    if (pageable.getSort().isSorted()) {
      where += String.format(ORDER_BY_STATEMENT,
          pageable.getSort()
              .stream()
              .map(order ->
                  String.format("%s %s", order.getProperty(), order.getDirection()))
              .collect(Collectors.joining(",")));
    }
    where += String.format(LIMIT_STATEMENT, pageable.getPageSize(), pageable.getOffset());

    String select = String.format(SELECT_STATEMENT, where);
    String count = String.format(SELECT_COUNT_STATEMENT, where);
    jdbcTemplate.queryForList(select, )
    jdbcTemplate.queryForList())

    return pageResults;
  }
}
