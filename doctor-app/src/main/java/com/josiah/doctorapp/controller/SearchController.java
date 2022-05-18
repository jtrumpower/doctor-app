package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.service.impl.SearchServiceJdbcImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {
  private final SearchServiceJdbcImpl searchService;

  @PostMapping("/search")
  public PagedSearchResponse searchPaged(@RequestBody SearchRequestJdbc searchRequest) {
    return searchService.pagedSearch(searchRequest);
  }

  @PostMapping("/search/typeahead")
  public SearchResponse searchTypeahead(@RequestBody SearchRequestJdbc searchRequest) {
    return searchService.search(searchRequest);
  }
}
