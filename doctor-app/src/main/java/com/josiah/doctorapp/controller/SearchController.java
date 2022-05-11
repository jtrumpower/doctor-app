package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.request.SearchRequestEnum;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.service.SearchService;
import com.josiah.doctorapp.service.SearchServiceImpl;
import com.josiah.doctorapp.service.SearchServiceJdbcImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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
  public SearchResponse search(@RequestBody SearchRequestEnum searchRequest) {
    return service.search(searchRequest);
  }

  @PostMapping("/search/jdbc")
  public SearchResponse searchJdcb(@RequestBody SearchRequestJdbc searchRequest) {
    return jdbcService.search(searchRequest);
  }
}
