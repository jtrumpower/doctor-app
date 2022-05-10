package com.josiah.doctorapp.controller.model.request;

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
  private String column;
  private String value;
  private int page;
  private int pageSize;
  private List<Sorting> sorting;
}
