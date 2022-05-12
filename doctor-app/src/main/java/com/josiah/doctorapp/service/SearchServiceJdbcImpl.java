package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;
import com.josiah.doctorapp.data.GeneralStatementCreator;
import com.josiah.doctorapp.service.mapper.SortMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Qualifier("searchServiceJdbc")
public class SearchServiceJdbcImpl implements SearchService<SearchRequestJdbc> {
  private static final String SELECT_COUNT_STATEMENT = "SELECT COUNT(*) FROM general_data";
  private static final String ORDER_BY_STATEMENT = " ORDER BY %s";

  private final SortMapper sortMapper;
  private final JdbcTemplate jdbcTemplate;


  public PagedSearchResponse pagedSearch(SearchRequestJdbc params) {

    Page<GeneralRow> pageResults = getPagedResults(params);

    return PagedSearchResponse.builder()
        .totalPages(pageResults.getTotalPages())
        .totalResults(pageResults.getTotalElements())
        .results(pageResults.getContent())
        .build();
  }

  public PagedSearchResponse search(SearchRequestJdbc params) {

    Slice<GeneralRow> pageResults = getSliceResults(params);

    return PagedSearchResponse.builder()
        .results(pageResults.getContent())
        .build();
  }

  private Page<GeneralRow> getPagedResults(SearchRequestJdbc params) {
    Pageable pageable = getPageable(params);

    List<GeneralRow> rows = jdbcTemplate.query(
        new GeneralStatementCreator(params, sortMapper),
        new com.josiah.doctorapp.data.rowmapper.GeneralRowMapper());
    Integer count = getCount(params, pageable);

    return new PageImpl<>(rows, pageable, count);
  }

  private Slice<GeneralRow> getSliceResults(SearchRequestJdbc params) {
    Pageable pageable = getPageable(params);

    List<GeneralRow> rows = jdbcTemplate.query(
        new GeneralStatementCreator(params, sortMapper),
        new com.josiah.doctorapp.data.rowmapper.GeneralRowMapper());

    return new SliceImpl<>(rows, pageable, false);
  }

  private Pageable getPageable(SearchRequestJdbc params) {
    return PageRequest.of(params.getPage(), params.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(params.getSorting())));
  }

  private Integer getCount(SearchRequestJdbc params, Pageable pageable) {
    StringBuilder sBuilder = new StringBuilder(SELECT_COUNT_STATEMENT);
    getCountWhere(params).ifPresent(sBuilder::append);
    getCountOrder(pageable).ifPresent(sBuilder::append);

    log.info(sBuilder.toString());
    return jdbcTemplate.queryForObject(sBuilder.toString(), Integer.class);
  }


  private Optional<String> getCountWhere(SearchRequestJdbc params) {
    if (!StringUtils.isEmpty(params.getColumns()) && !StringUtils.isEmpty(params.getValue())) {
      return Optional.of(" where " +
          Arrays.stream(params.getColumns().split("\\|"))
              .map(val -> String.format("lower(%s) like '%%%s%%'", val, params.getValue()))
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
