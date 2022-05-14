package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.DataloadRequest;
import com.josiah.doctorapp.data.entity.JobEntity;
import java.util.List;

public interface JobService {
  List<JobEntity> getJobs();
  void runJob(DataloadRequest job);
}
