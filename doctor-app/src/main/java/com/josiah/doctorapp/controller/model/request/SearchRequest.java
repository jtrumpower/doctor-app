package com.josiah.doctorapp.controller.model.request;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
  private String value;
  @Default
  private int page = 0;
  @Default
  private int pageSize = 25;
  @Default
  private List<Sorting> sorting = new ArrayList<>();
}
