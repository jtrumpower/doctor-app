package com.josiah.doctorapp.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import java.io.IOException;
import java.io.OutputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CsvHelper {
  private static final char DELIMITER = ',';
  private static final char QUOTE = '"';
  private static final String LINE_SEPARATOR = "\n";

  //private final CsvMapper mapper;

  public  <T> void writeToOutput(T entry, OutputStream outputStream) {
    /*CsvSchema schema = mapper.schemaFor(entry.getClass());

    try {
      outputStream.write(mapper.writer(schema
              .withColumnSeparator(DELIMITER)
              .withQuoteChar(QUOTE)
              .withLineSeparator(LINE_SEPARATOR))
          .writeValueAsBytes(entry));

    } catch (JsonProcessingException e) {
      log.error("Failed to write line: {}", entry);
    } catch (IOException e) {
      log.error("Failed to write entry to stream: {}", entry);
    }*/
  }

  public <T> T readFromString(String line, Class<T> clazz) throws JsonProcessingException {
    /*CsvMapper m = new CsvMapper();
    CsvSchema schema = m.schemaFor(clazz)
        .withoutHeader()
        .withLineSeparator("\n")
        .withColumnSeparator(',');*/

    return null;
  }
}
