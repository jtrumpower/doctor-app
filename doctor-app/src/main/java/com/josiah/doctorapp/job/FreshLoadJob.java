package com.josiah.doctorapp.job;

import com.josiah.doctorapp.data.entity.JobEntity;
import com.josiah.doctorapp.data.repository.JobRepository;
import com.josiah.doctorapp.data.repository.LockRepository;
import com.josiah.doctorapp.job.model.FreshLoadDataParam;
import com.josiah.doctorapp.service.FreshDataService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FreshLoadJob extends Job<FreshLoadDataParam> {

  private final FreshDataService dataService;

  public FreshLoadJob(LockRepository lockRepository,
      JobRepository jobRepository, FreshDataService dataService) {
    super(lockRepository, jobRepository);
    this.dataService = dataService;
  }

  @Override
  public void runJob(FreshLoadDataParam params) {

    try {
      dataService.process(params);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }

  }

  @Override
  protected JobEntity insertJob(FreshLoadDataParam params) {
    return jobRepository.save(
        JobEntity.builder()
            .name("Fresh data load")
            .description(String.format("Load fresh data: %s", params.toString()))
            .build());
  }

}
