package com.josiah.doctorapp;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorConfig {

  @Bean
  public CsvMapper csvMapper() {
    return new CsvMapper();
  }
}
