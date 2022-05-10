package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import com.josiah.doctorapp.service.mapper.SortMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

  private final GeneralRepository repository;
  private final GeneralRowMapper rowMapper;
  private final SortMapper sortMapper;

  public SearchResponse search(SearchRequest params) {

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

  private Page<GeneralEntity> getResults(SearchRequest params) {
    Pageable pageable = PageRequest.of(params.getPage(), params.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(params.getSorting())));

    Page<GeneralEntity> pageResults;
    if (StringUtils.isEmpty(params.getValue())) {
      pageResults = repository.getAllNative(pageable);
    } else {
      pageResults = repository.getByName(
          params.getValue(),
          pageable);
    }

    return pageResults;
  }
}
