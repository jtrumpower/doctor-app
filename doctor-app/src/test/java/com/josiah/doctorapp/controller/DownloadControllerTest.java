package com.josiah.doctorapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.service.DownloadService;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

@ExtendWith(MockitoExtension.class)
class DownloadControllerTest {

  @Mock
  private DownloadService downloadService;
  @Mock
  private HttpServletResponse response;

  @InjectMocks
  private DownloadController sut;

  @Captor
  ArgumentCaptor<SearchRequestJdbc> captor;

  @Test
  @SneakyThrows
  void shouldCallDownloadService() {
    // given
    String value = "search";
    String columns = "some column";
    SearchRequestJdbc searchRequest = SearchRequestJdbc.builder()
        .value(value)
        .columns(columns)
        .build();

    doNothing().when(downloadService).printResults(captor.capture(), any());

    // when
    sut.getAllData(value, columns, response);

    // then
    SearchRequestJdbc searchCaptor = captor.getValue();
    assertThat(searchCaptor.getValue()).isEqualTo(searchRequest.getValue());
    assertThat(searchCaptor.getColumns()).isEqualTo(searchRequest.getColumns());

    then(response).should().setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=results.xls");
    then(response).should().setContentType("text/csv");
  }
}
