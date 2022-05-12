package com.josiah.doctorapp.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileHelper {

  public File writeFile(InputStream stream, String filePath) throws IOException {
    log.info("Writing file: {}", filePath);
    try (OutputStream outputStream = new FileOutputStream(filePath, false)) {
      stream.transferTo(outputStream);

      return getFile(filePath);
    } catch (IOException e) {
      log.error("Error when copying file: {}", filePath, e);
      throw e;
    }
  }

  public FileInputStream getFileInputStream(String path) throws FileNotFoundException {
    return new FileInputStream(path);
  }

  public FileInputStream getFileInputStream(File file) throws FileNotFoundException {
    return new FileInputStream(file);
  }

  public File getFile(String path) {
    return new File(path);
  }

  public void delete(File file) {
    try {
      FileUtils.deleteDirectory(file);
    } catch (IOException e) {
      log.error("Failed to delete directory: {}", file.getPath(), e);
    }
  }

  public void delete(String file) {
    delete(new File(file));
  }
}
