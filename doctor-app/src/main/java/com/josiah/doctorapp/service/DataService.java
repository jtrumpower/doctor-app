package com.josiah.doctorapp.service;

import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.enums.DataLoadType;

public interface DataService {
  void process(LoadDataParam param, DataLoadType type);
}
