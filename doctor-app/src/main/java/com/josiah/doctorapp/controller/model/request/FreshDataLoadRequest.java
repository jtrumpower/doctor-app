package com.josiah.doctorapp.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreshDataLoadRequest {
  long numRows;
  boolean newFile;
  boolean allRows;
}
