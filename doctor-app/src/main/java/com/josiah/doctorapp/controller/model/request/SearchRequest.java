package com.josiah.doctorapp.controller.model.request;

import com.josiah.doctorapp.service.enums.RowTypeEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
  private RowTypeEnum rowType;
  private String value;
  private int page;
  private int pageSize;
  private List<Sorting> sorting;
}
