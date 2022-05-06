package com.josiah.doctorapp.api.model.response;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetastoreResponse {
  private List<Distribution> distribution;
  private Date modified;
}
