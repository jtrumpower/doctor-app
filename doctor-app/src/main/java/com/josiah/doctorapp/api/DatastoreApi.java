package com.josiah.doctorapp.api;

import com.josiah.doctorapp.api.model.request.DatastoreRequest;
import java.io.InputStream;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.Query;

@Path("/datastore/query")
public interface DatastoreApi {
  @GET
  @Path("{id}")
  InputStream queryDataById(@BeanParam DatastoreRequest request);
}
