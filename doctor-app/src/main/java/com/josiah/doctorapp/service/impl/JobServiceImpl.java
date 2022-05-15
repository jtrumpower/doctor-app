package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.controller.model.request.DataloadRequest;
import com.josiah.doctorapp.data.entity.JobEntity;
import com.josiah.doctorapp.data.repository.JobRepository;
import com.josiah.doctorapp.job.DeltaLoadJob;
import com.josiah.doctorapp.job.FreshLoadJob;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.JobService;
import com.josiah.doctorapp.service.enums.DataLoadType;
import com.josiah.doctorapp.service.mapper.DataLoadMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

  private final JobRepository jobRepository;
  private final DeltaLoadJob deltaLoadJob;
  private final FreshLoadJob freshLoadJob;
  private final DataLoadMapper mapper;


  @Override
  public List<JobEntity> getJobs() {
    return jobRepository.findAllOrderByCreatedDesc();
  }

  @Override
  public void runJob(DataloadRequest job) {
    LoadDataParam loadData = mapper.mapFromRequest(job);
    if (job.getType().equals(DataLoadType.DELTA)) {
      deltaLoadJob.run(loadData);
    } else {
      freshLoadJob.run(loadData);
    }
  }

  @Override
  public void delete(long id) {
    jobRepository.delete(
        jobRepository.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No job found by id: %s", id))));
  }
}
