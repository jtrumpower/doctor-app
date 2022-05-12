package com.josiah.doctorapp.helper;

import static com.josiah.doctorapp.api.constants.Constants.WHITELIST;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.request.Sorting;
import com.josiah.doctorapp.service.mapper.SortMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageableHelper {

  private final SortMapper sortMapper;

  public Pageable createPageable(SearchRequestJdbc searchRequest) {
    List<Sorting> sortList = searchRequest.getSorting().stream().filter(sort -> WHITELIST.contains(sort.getField())).collect(
        Collectors.toList());

   return PageRequest.of(searchRequest.getPage(), searchRequest.getPageSize(),
        Sort.by(sortMapper.mapSortingToSort(sortList)));
  }
}
