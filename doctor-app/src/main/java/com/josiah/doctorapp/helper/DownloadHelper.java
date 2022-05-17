package com.josiah.doctorapp.helper;

import com.josiah.doctorapp.api.MetastoreApi;
import com.josiah.doctorapp.api.model.request.MetastoreRequest;
import com.josiah.doctorapp.api.model.response.Distribution;
import com.josiah.doctorapp.api.model.response.DistributionData;
import com.josiah.doctorapp.api.model.response.MetastoreResponse;
import com.josiah.doctorapp.config.properties.CmsProperties;
import com.josiah.doctorapp.config.properties.CsvProperties;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DownloadHelper {
  private final MetastoreApi metastoreApi;
  private final FileHelper fileHelper;
  private final CmsProperties cmsProperties;
  private final CsvProperties csvProperties;

  public String getDownloadUrl(MetastoreResponse metastore) {
    return Optional.ofNullable(metastore)
        .map(MetastoreResponse::getDistribution)
        .map(dist -> dist.get(0))
        .map(Distribution::getData)
        .map(DistributionData::getDownloadURL)
        .orElseThrow(() ->
            new RuntimeException(String.format("Failed to get download URL from Metastore Response: %s", metastore)));
  }

  public void downloadFile() throws IOException {
    MetastoreResponse metaResponse = metastoreApi.getMetastoreItems(
        MetastoreRequest.builder()
            .id(cmsProperties.getMetastoreId())
            .build());

    InputStream stream = new URL(getDownloadUrl(metaResponse)).openStream();
    fileHelper.delete(csvProperties.getLocation());
    fileHelper.writeFile(stream, csvProperties.getLocation());
  }
}
