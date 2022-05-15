package com.josiah.doctorapp.job.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoadDataParam {
  long numRows;
  boolean allRows;
  boolean newFile;
}
