package com.josiah.doctorapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.josiah.doctorapp.service.DataService;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

  private final DataService dataService;

  @GetMapping("/load")
  public void loadData() {
    dataService.loadData();
  }
}
