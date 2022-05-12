package com.josiah.doctorapp.config.properties;

import lombok.Builder;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@Builder
@ConstructorBinding
@ConfigurationProperties("csv")
public class CsvProperties {
  String location;
}
