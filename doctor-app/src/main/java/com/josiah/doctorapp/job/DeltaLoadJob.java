package com.josiah.doctorapp.job;

import com.josiah.doctorapp.data.entity.JobEntity;
import com.josiah.doctorapp.data.repository.JobRepository;
import com.josiah.doctorapp.data.repository.LockRepository;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.DataService;
import com.josiah.doctorapp.service.impl.DataServiceImpl;
import com.josiah.doctorapp.service.enums.CsvServiceType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class DeltaLoadJob extends Job<LoadDataParam> {

  private final DataService dataService;

  public DeltaLoadJob(LockRepository lockRepository,
      JobRepository jobRepository, DataServiceImpl dataService) {
    super(lockRepository, jobRepository);
    this.dataService = dataService;
  }

  @Override
  public void runJob(LoadDataParam params) {

    try {
      dataService.process(params, CsvServiceType.DELTA);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }

  }

  @Override
  protected JobEntity insertJob(LoadDataParam params) {
    return jobRepository.save(
        JobEntity.builder()
            .name("Delta data load")
            .description(String.format("Perform delta on data: %s", params.toString()))
            .build());
  }

}
