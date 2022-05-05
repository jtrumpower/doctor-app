package com.josiah.doctorapp.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.josiah.doctorapp.api.DatastoreApi;
import com.josiah.doctorapp.api.model.request.DatastoreRequest;
import com.josiah.doctorapp.config.properties.CmsProperties;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataService {

  private final GeneralRepository repository;
  private final DatastoreApi datastoreApi;
  private final CmsProperties properties;

  public void loadData() {
    InputStream stream = datastoreApi.queryDataById(
        DatastoreRequest.builder()
            .id(properties.getDatastoreId())
            .format("csv")
            .limit(20L)
            .build());


  }

  public void store(InputStream stream) {
    CsvMapper m = new CsvMapper();
    CsvSchema schema = m.schemaFor(FooBar.class).withoutHeader().withLineSeparator("\n").withColumnSeparator(',');
  }
}
