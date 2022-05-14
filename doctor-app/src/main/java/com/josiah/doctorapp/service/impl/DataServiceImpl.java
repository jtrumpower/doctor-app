package com.josiah.doctorapp.service.impl;


import com.josiah.doctorapp.config.properties.CsvProperties;
import com.josiah.doctorapp.helper.DownloadHelper;
import com.josiah.doctorapp.helper.FileHelper;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.DataService;
import com.josiah.doctorapp.service.enums.CsvServiceType;
import com.josiah.doctorapp.service.factory.CsvImportFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
  private final CsvImportFactory factory;
  private final DownloadHelper downloadHelper;
  private final FileHelper fileHelper;
  private final CsvProperties csvProperties;

  public void process(LoadDataParam param, CsvServiceType type) {
    try {
      if (!fileHelper.getFile(csvProperties.getLocation()).exists() || param.isNewFile()) {
        downloadHelper.downloadFile();
      }

      FileInputStream inputStream = fileHelper.getFileInputStream(csvProperties.getLocation());

      factory.create(type)
          .importCsv(inputStream, param);
    } catch (IOException | SQLException e) {
      log.error("Failed to process CSV", e);
    }
  }
}
