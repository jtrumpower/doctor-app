package com.josiah.doctorapp.service.factory;

import com.josiah.doctorapp.service.CsvImportService;
import com.josiah.doctorapp.service.enums.DataLoadType;
import com.josiah.doctorapp.service.impl.DeltaCsvImportService;
import com.josiah.doctorapp.service.impl.FreshCsvImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CsvImportFactory {
  private final FreshCsvImportService freshService;
  private final DeltaCsvImportService deltaCsvImportService;

  public CsvImportService create(DataLoadType type) {
    if (type.equals(DataLoadType.DELTA)) {
      return deltaCsvImportService;
    }

    return freshService;
  }
}
