package com.josiah.doctorapp.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DownloadHelper {

  public InputStream streamFile(String url) throws IOException {
    URL yahoo = new URL(url);
    URLConnection yc = yahoo.openConnection();
    return yc.getInputStream();
  }
}
