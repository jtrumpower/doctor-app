package com.josiah.doctorapp.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.josiah.doctorapp.config.properties.CsvProperties;
import com.josiah.doctorapp.helper.DownloadHelper;
import com.josiah.doctorapp.helper.FileHelper;
import com.josiah.doctorapp.job.model.LoadDataParam;
import com.josiah.doctorapp.service.CsvImportService;
import com.josiah.doctorapp.service.enums.DataLoadType;
import com.josiah.doctorapp.service.factory.CsvImportFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.print.DocFlavor.STRING;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataServiceImplTest {
  private static final String LOCATION = "location";

  @Mock
  private CsvImportFactory factory;
  @Mock
  private DownloadHelper downloadHelper;
  @Mock
  private FileHelper fileHelper;
  @Mock
  private CsvProperties csvProperties;

  @InjectMocks
  private DataServiceImpl sut;


  @Test
  @SneakyThrows
  void shouldDownloadNewFileIfDoesNotExist() {
    // given
    LoadDataParam param = LoadDataParam.builder()
        .newFile(false)
        .build();
    DataLoadType type = DataLoadType.DELTA;
    File file = mock(File.class);
    FileInputStream inputStream = mock(FileInputStream.class);
    CsvImportService importService = mock(CsvImportService.class);

    given(csvProperties.getLocation()).willReturn(LOCATION);
    given(fileHelper.getFile(LOCATION)).willReturn(file);
    given(file.exists()).willReturn(false);
    doNothing().when(downloadHelper).downloadFile();
    given(fileHelper.getFileInputStream(LOCATION)).willReturn(inputStream);
    given(factory.create(type)).willReturn(importService);
    doNothing().when(importService).importCsv(inputStream, param);

    // when
    sut.process(param, type);

    // then
    then(factory).should().create(type);
    then(fileHelper).should().getFileInputStream(LOCATION);
    then(downloadHelper).should().downloadFile();
  }

  @Test
  @SneakyThrows
  void shouldDownloadNewFileIfParamTrue() {
    // given
    LoadDataParam param = LoadDataParam.builder()
        .newFile(true)
        .build();
    DataLoadType type = DataLoadType.DELTA;
    File file = mock(File.class);
    FileInputStream inputStream = mock(FileInputStream.class);
    CsvImportService importService = mock(CsvImportService.class);

    given(csvProperties.getLocation()).willReturn(LOCATION);
    given(fileHelper.getFile(LOCATION)).willReturn(file);
    given(file.exists()).willReturn(true);
    doNothing().when(downloadHelper).downloadFile();
    given(fileHelper.getFileInputStream(LOCATION)).willReturn(inputStream);
    given(factory.create(type)).willReturn(importService);
    doNothing().when(importService).importCsv(inputStream, param);

    // when
    sut.process(param, type);

    // then
    then(factory).should().create(type);
    then(fileHelper).should().getFileInputStream(LOCATION);
    then(downloadHelper).should().downloadFile();
  }

  @Test
  @SneakyThrows
  void shouldNotDownloadNewFileIfParamFalse() {
    // given
    LoadDataParam param = LoadDataParam.builder()
        .newFile(false)
        .build();
    DataLoadType type = DataLoadType.DELTA;
    File file = mock(File.class);
    FileInputStream inputStream = mock(FileInputStream.class);
    CsvImportService importService = mock(CsvImportService.class);

    given(csvProperties.getLocation()).willReturn(LOCATION);
    given(fileHelper.getFile(LOCATION)).willReturn(file);
    given(file.exists()).willReturn(true);
    given(fileHelper.getFileInputStream(LOCATION)).willReturn(inputStream);
    given(factory.create(type)).willReturn(importService);
    doNothing().when(importService).importCsv(inputStream, param);

    // when
    sut.process(param, type);

    // then
    then(factory).should().create(type);
    then(fileHelper).should().getFileInputStream(LOCATION);
    then(downloadHelper).shouldHaveNoInteractions();
  }
}
