package com.josiah.doctorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DoctorAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(DoctorAppApplication.class, args);
  }

}
