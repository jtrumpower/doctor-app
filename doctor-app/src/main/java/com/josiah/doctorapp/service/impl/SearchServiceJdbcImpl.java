package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.data.GeneralStatementCreator;
import com.josiah.doctorapp.data.rowmapper.CountRowMapper;
import com.josiah.doctorapp.helper.PageableHelper;
import com.josiah.doctorapp.service.SearchService;
import com.josiah.doctorapp.service.mapper.SortMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Qualifier("searchServiceJdbc")
public class SearchServiceJdbcImpl implements SearchService<SearchRequestJdbc> {

  private final SortMapper sortMapper;
  private final JdbcTemplate jdbcTemplate;
  private final PageableHelper pageHelper;


  public PagedSearchResponse pagedSearch(SearchRequestJdbc params) {

    Page<GeneralRow> results = getPagedResults(params);

    return PagedSearchResponse.builder()
        .totalPages(results.getTotalPages())
        .totalResults(results.getTotalElements())
        .results(results.getContent())
        .build();
  }

  public SearchResponse search(SearchRequestJdbc params) {

    Slice<GeneralRow> results = getSearchResults(params);

    return SearchResponse.builder()
        .results(results.getContent())
        .build();
  }

  private Page<GeneralRow> getPagedResults(SearchRequestJdbc params) {
    Pageable pageable = getPageable(params);

    List<GeneralRow> rows = jdbcTemplate.query(
        GeneralStatementCreator.builder()
            .request(params)
            .pageable(pageHelper.createPageable(params))
            .build(),
        new BeanPropertyRowMapper<>(GeneralRow.class));
    List<Integer> count = jdbcTemplate.query(
        GeneralStatementCreator.builder()
            .request(params)
            .count(true)
            .build(),
        new CountRowMapper());

    return new PageImpl<>(rows, pageable, count.get(0));
  }

  private Slice<GeneralRow> getSearchResults(SearchRequestJdbc params) {
    Pageable pageable = getPageable(params);

    List<GeneralRow> rows = jdbcTemplate.query(
        GeneralStatementCreator.builder()
            .request(params)
            .pageable(pageHelper.createPageable(params))
            .distinct(true)
            .build(),
        new BeanPropertyRowMapper<>(GeneralRow.class));

    return new SliceImpl<>(rows, pageable, false);
  }

  private Pageable getPageable(SearchRequestJdbc params) {
    return PageRequest.of(params.getPage(), params.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(params.getSorting())));
  }
}
