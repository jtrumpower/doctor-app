package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import java.io.PrintWriter;

public interface DownloadService {
  void printResults(SearchRequestJdbc searchRequestJdbc, PrintWriter writer);
}
