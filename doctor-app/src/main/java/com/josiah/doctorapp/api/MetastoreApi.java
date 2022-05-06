package com.josiah.doctorapp.api;

import com.josiah.doctorapp.api.model.request.DatastoreRequest;
import com.josiah.doctorapp.api.model.request.MetastoreRequest;
import com.josiah.doctorapp.api.model.response.MetastoreResponse;
import java.io.InputStream;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/metastore/schemas/dataset/items")
public interface MetastoreApi {
  @GET
  @Path("{id}")
  MetastoreResponse getMetastoreItems(@BeanParam MetastoreRequest request);
}
