package com.josiah.doctorapp.service;

import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.helper.CsvHelper;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import java.io.OutputStream;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DownloadService {

  private final GeneralRepository generalRepo;
  private final EntityManager entityManager;
  private final GeneralRowMapper mapper;
  private final CsvHelper helper;

  @Transactional(readOnly = true)
  public void getAllData( OutputStream outputStream) {
    try (Stream<GeneralEntity> entries = generalRepo.getAll()) {
      entries.forEach(entry -> {
        helper.writeToOutput(mapper.mapGeneralRowToEntity(entry), outputStream);
        entityManager.detach(entry);
      });
    }
  }
}
