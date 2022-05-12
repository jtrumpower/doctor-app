package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.SearchRequestEnum;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;
import com.josiah.doctorapp.service.SearchServiceImpl;
import com.josiah.doctorapp.service.SearchServiceJdbcImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SearchController {
  private final SearchServiceImpl service;
  private final SearchServiceJdbcImpl jdbcService;

  public SearchController(SearchServiceImpl service, SearchServiceJdbcImpl jdbcService) {
    this.service = service;
    this.jdbcService = jdbcService;
  }

  @PostMapping("/search")
  public PagedSearchResponse search(@RequestBody SearchRequestEnum searchRequest) {
    return service.pagedSearch(searchRequest);
  }

  @PostMapping("/search/paged")
  public PagedSearchResponse searchPaged(@RequestBody SearchRequestJdbc searchRequest) {
    return jdbcService.pagedSearch(searchRequest);
  }

  @PostMapping("/search/typeahead")
  public PagedSearchResponse searchTypeahead(@RequestBody SearchRequestJdbc searchRequest) {
    return jdbcService.search(searchRequest);
  }
}
