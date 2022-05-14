package com.josiah.doctorapp.service;

import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.enums.CsvServiceType;

public interface DataService {
  void process(LoadDataParam param, CsvServiceType type);
}
