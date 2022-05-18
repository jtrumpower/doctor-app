package com.josiah.doctorapp.config.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("csv")
public class CsvProperties {
  String location;
}
