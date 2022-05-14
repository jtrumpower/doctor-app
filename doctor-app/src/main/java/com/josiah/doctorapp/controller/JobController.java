package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.DataloadRequest;
import com.josiah.doctorapp.data.entity.JobEntity;
import com.josiah.doctorapp.service.JobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

  private final JobService jobService;

  @GetMapping
  public List<JobEntity> getJobStatus() {
    return jobService.getJobs();
  }

  @PostMapping("/dataloader")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void createDataloaderJob(@RequestBody DataloadRequest jobRequest) {
    jobService.runJob(jobRequest);
  }
}
