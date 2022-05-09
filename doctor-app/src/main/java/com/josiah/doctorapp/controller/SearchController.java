package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class SearchController {
  private final SearchService service;

  @PostMapping("/search")
  public SearchResponse search(@RequestBody SearchRequest searchRequest) {
    return service.search(searchRequest);
  }
}
