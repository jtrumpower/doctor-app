package com.josiah.doctorapp.helper;

import com.josiah.doctorapp.api.model.response.Distribution;
import com.josiah.doctorapp.api.model.response.DistributionData;
import com.josiah.doctorapp.api.model.response.MetastoreResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DownloadHelper {

  public InputStream streamFile(String fileUrl) throws IOException {
    URL url = new URL(fileUrl);
    URLConnection conn = url.openConnection();
    return conn.getInputStream();
  }

  public String getDownloadUrl(MetastoreResponse metastore) {
    return Optional.ofNullable(metastore)
        .map(MetastoreResponse::getDistribution)
        .map(dist -> dist.get(0))
        .map(Distribution::getData)
        .map(DistributionData::getDownloadURL)
        .orElseThrow(() ->
            new RuntimeException(String.format("Failed to get download URL from Metastore Response: %s", metastore)));
  }
}
