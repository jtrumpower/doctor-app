package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class SearchController {
  private final SearchService service;

  @GetMapping("/search")
  public SearchResponse search(@RequestParam("name") String name, @RequestParam("pageSize") int pageSize) {
    return service.search(name, pageSize);
  }
}
