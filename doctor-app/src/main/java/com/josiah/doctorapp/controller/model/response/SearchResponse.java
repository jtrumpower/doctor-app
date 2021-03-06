package com.josiah.doctorapp.controller.model.response;

import com.josiah.doctorapp.service.model.GeneralRow;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
  List<GeneralRow> results;
}
