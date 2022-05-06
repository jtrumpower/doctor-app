package com.josiah.doctorapp.api.model.request;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetastoreRequest {

  @PathParam("id")
  private String id;

  @QueryParam("show-reference-ids")
  private boolean showReferenceIds;
}
