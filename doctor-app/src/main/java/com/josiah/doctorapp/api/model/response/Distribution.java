package com.josiah.doctorapp.api.model.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Distribution {
  private UUID identifier;
  private DistributionData data;
}
