package com.josiah.doctorapp.controller.model.request;

import com.josiah.doctorapp.service.enums.DataLoadType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateJobRequest {
  DataLoadType type;
  String allRows;
  int numRows;
  boolean newFile;
}
