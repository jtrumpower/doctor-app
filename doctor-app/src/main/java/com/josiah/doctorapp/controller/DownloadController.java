package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.service.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DownloadController {

  private final DownloadService downloadService;

  @GetMapping(
      value = "/all",
      produces = "application/octet-stream"
  )
  public ResponseEntity<StreamingResponseBody> getAllData() {
    StreamingResponseBody stream = downloadService::getAllData;

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=results.xls")
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(stream);
  }
}
