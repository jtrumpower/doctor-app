package com.josiah.doctorapp.service.impl;

import com.josiah.doctorapp.data.entity.LockEntity;
import com.josiah.doctorapp.data.repository.LockRepository;
import com.josiah.doctorapp.service.LockService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LockServiceImpl implements LockService {

  private final LockRepository lockRepository;


  @Override
  public List<LockEntity> getLocks() {
    return lockRepository.getAllLocksOrderByCreatedDesc();
  }

  @Override
  public void deleteLock(long id) {
    lockRepository.delete(
        lockRepository.findById((int) id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("No lock by id %s found", id))));
  }
}
