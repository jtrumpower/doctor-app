package com.josiah.doctorapp.controller.model.request;

import com.josiah.doctorapp.service.enums.DataLoadType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataloadRequest {
  private DataLoadType type;
  private long numRows;
  private boolean newFile;
  private boolean allRows;
}
