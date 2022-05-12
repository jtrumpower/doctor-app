package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequestEnum;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.service.enums.RowTypeEnum;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import com.josiah.doctorapp.service.mapper.SortMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("searchService")
public class SearchServiceImpl implements SearchService<SearchRequestEnum> {

  private final GeneralRepository repository;
  private final GeneralRowMapper rowMapper;
  private final SortMapper sortMapper;

  public PagedSearchResponse pagedSearch(SearchRequestEnum params) {

    Page<GeneralEntity> pageResults = getResults(params);

    return PagedSearchResponse.builder()
        .totalPages(pageResults.getTotalPages())
        .totalResults(pageResults.getTotalElements())
        .results(pageResults.getContent()
            .stream()
            .map(rowMapper::mapEntityToGeneralRow)
            .collect(Collectors.toList()))
        .build();
  }

  @Override
  public SearchResponse search(SearchRequestEnum params) {
    return null;
  }

  private Page<GeneralEntity> getResults(SearchRequestEnum params) {
    Pageable pageable = PageRequest.of(params.getPage(), params.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(params.getSorting())));

    Page<GeneralEntity> pageResults;
    if (StringUtils.isEmpty(params.getValue())) {
      pageResults = repository.getAllNative(pageable);
    } else if (params.getRowType().equals(RowTypeEnum.FORM_OF_PAYMENT)) {
      pageResults = repository.getByFormOfPayment(
          params.getValue(),
          pageable);
    } else if (params.getRowType().equals(RowTypeEnum.NATURE_OF_PAYMENT)) {
      pageResults = repository.getByNatureOfPayment(
          params.getValue(),
          pageable);
    } else if (params.getRowType().equals(RowTypeEnum.TEACHING_HOSPITAL_NAME)) {
      pageResults = repository.getByTeachingHospitalName(
          params.getValue(),
          pageable);
    } else {
      pageResults = repository.getByName(
          params.getValue(),
          pageable);
    }

    return pageResults;
  }
}
