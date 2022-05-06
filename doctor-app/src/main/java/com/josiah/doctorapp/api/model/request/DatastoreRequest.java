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
public class DatastoreRequest {

  @PathParam("id")
  private String id;

  @QueryParam("limit")
  Long limit;

  @Default
  @QueryParam("offset")
  long offset = 0;

  @Default
  @QueryParam("count")
  boolean count = true;

  @Default
  @QueryParam("results")
  boolean results = true;

  @Default
  @QueryParam("schema")
  boolean schema = true;

  @Default
  @QueryParam("keys")
  boolean keys = true;

  @QueryParam("format")
  String format;

  @Default
  @QueryParam("rowIds")
  boolean rowIds = true;
}
