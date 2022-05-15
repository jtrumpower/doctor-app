package com.josiah.doctorapp.controller;

import com.josiah.doctorapp.data.entity.LockEntity;
import com.josiah.doctorapp.service.LockService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/locks")
@RequiredArgsConstructor
public class LockController {

  private final LockService lockService;

  @GetMapping
  public List<LockEntity> getJobStatus() {
    return lockService.getLocks();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteLock(@PathVariable long id) {
    lockService.deleteLock(id);
  }
}
