package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.api.MetastoreApi;
import com.josiah.doctorapp.api.model.request.MetastoreRequest;
import com.josiah.doctorapp.api.model.response.MetastoreResponse;
import com.josiah.doctorapp.config.properties.CmsProperties;
import com.josiah.doctorapp.config.properties.CsvProperties;
import com.josiah.doctorapp.helper.DownloadHelper;
import com.josiah.doctorapp.helper.FileHelper;
import com.josiah.doctorapp.job.model.FreshLoadDataParam;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.CsvImportService;
import com.josiah.doctorapp.service.DataService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeltaDataService implements DataService<LoadDataParam> {

  private final DeltaCsvImportService csvImportService;
  private final DownloadHelper downloadHelper;
  private final FileHelper fileHelper;
  private final CsvProperties csvProperties;

  @Override
  public void process(LoadDataParam param) {
    try {
      downloadHelper.downloadFile();

      FileInputStream inputStream = fileHelper.getFileInputStream(csvProperties.getLocation());

      csvImportService.stream(inputStream, param);
    } catch (IOException | SQLException e) {
      log.error("Failed to process CSV", e);
    }
  }
}
