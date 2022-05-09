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
  private String name;
  private int page;
  private int pageSize;
  private List<Sort> sorting;
}
