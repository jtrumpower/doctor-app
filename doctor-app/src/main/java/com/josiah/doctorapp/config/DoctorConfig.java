package com.josiah.doctorapp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.josiah.doctorapp.api.DatastoreApi;
import com.josiah.doctorapp.api.MetastoreApi;
import com.josiah.doctorapp.config.properties.CmsProperties;
import java.util.Arrays;
import java.util.List;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorConfig {

  /*@Bean
  public CsvMapper csvMapper() {
    return new CsvMapper();
  }*/

  @Bean
  public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
    JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
    provider.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    return provider;
  }



  @Bean
  public DatastoreApi datastoreApi(CmsProperties cmsProperties, JacksonJaxbJsonProvider jsonProvider) {
    return JAXRSClientFactory.create(cmsProperties.getApi(), DatastoreApi.class, List.of(jsonProvider));
  }

  @Bean
  public MetastoreApi metastoreApiApi(CmsProperties cmsProperties, JacksonJaxbJsonProvider jsonProvider) {
    return JAXRSClientFactory.create(cmsProperties.getApi(), MetastoreApi.class, List.of(jsonProvider));
  }
}
