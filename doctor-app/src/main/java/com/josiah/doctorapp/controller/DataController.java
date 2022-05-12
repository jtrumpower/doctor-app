package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.FreshDataLoadRequest;
import com.josiah.doctorapp.job.FreshLoadJob;
import com.josiah.doctorapp.service.mapper.FreshLoadMapper;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class DataController {

  private final FreshLoadJob job;
  private final FreshLoadMapper mapper;

  @PostMapping("/dataloader/fresh")
  public String loadData(@RequestBody FreshDataLoadRequest dataLoadRequest) {
    job.run(mapper.mapFromRequest(dataLoadRequest));

    return String.format("started data load at: %s", new Date());
  }
}
