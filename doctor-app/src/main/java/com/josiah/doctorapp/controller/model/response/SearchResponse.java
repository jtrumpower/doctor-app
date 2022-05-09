package com.josiah.doctorapp.controller.model.response;

import com.josiah.doctorapp.service.model.GeneralRow;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SearchResponse {
  List<GeneralRow> results;
  long totalResults;
  int totalPages;
}
