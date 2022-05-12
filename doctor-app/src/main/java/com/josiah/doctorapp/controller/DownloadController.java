package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.service.DownloadService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DownloadController {

  private final DownloadService downloadService;

  @GetMapping(
      value = "/download",
      produces = "application/octet-stream"
  )
  public void getAllData(@RequestParam String value, @RequestParam String columns, HttpServletResponse response) throws IOException {

    response.setContentType("text/csv");
    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=results.xls");

    downloadService.printResults(
        SearchRequestJdbc.builder()
            .value(value)
            .columns(columns)
            .build(),
        response.getWriter());
  }
}
