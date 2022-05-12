package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.config.properties.CsvProperties;
import com.josiah.doctorapp.helper.DownloadHelper;
import com.josiah.doctorapp.helper.FileHelper;
import com.josiah.doctorapp.job.model.FreshLoadDataParam;
import com.josiah.doctorapp.service.CsvImportService;
import com.josiah.doctorapp.service.DataService;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FreshDataService implements DataService<FreshLoadDataParam> {

  private final CsvImportService csvImportService;
  private final DownloadHelper downloadHelper;
  private final FileHelper fileHelper;
  private final CsvProperties csvProperties;

  @Override
  public void process(FreshLoadDataParam param) {
    try {
      if (!fileHelper.getFile(csvProperties.getLocation()).exists() || param.isNewFile()) {
        downloadHelper.downloadFile();
      }

      FileInputStream inputStream = fileHelper.getFileInputStream(csvProperties.getLocation());

      csvImportService.stream(inputStream, param);
    } catch (IOException | SQLException e) {
      log.error("Failed to process CSV", e);
    }
  }
}
