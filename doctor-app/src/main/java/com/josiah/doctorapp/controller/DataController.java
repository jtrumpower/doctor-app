package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.DataloadRequest;
import com.josiah.doctorapp.job.DeltaLoadJob;
import com.josiah.doctorapp.job.FreshLoadJob;
import com.josiah.doctorapp.service.mapper.DataLoadMapper;
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

  /*private final FreshLoadJob job;
  private final DeltaLoadJob deltaJob;
  private final DataLoadMapper mapper;

  @PostMapping("/dataloader/fresh")
  public String loadFreshData(@RequestBody DataloadRequest dataLoadRequest) {
    job.run(mapper.mapFromRequest(dataLoadRequest));

    return String.format("started data load at: %s", new Date());
  }

  @PostMapping("/dataloader")
  public String loadData(@RequestBody DataloadRequest dataLoadRequest) {
    deltaJob.run(mapper.mapFromRequest(dataLoadRequest));

    return String.format("started data load at: %s", new Date());
  }*/
}
