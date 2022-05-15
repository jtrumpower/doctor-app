package com.josiah.doctorapp.exception;

import com.josiah.doctorapp.exception.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalResponseExceptionHandler {
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ErrorDTO> generateError(ResponseStatusException ex) {
    return new ResponseEntity<>(
        ErrorDTO.builder()
            .status(ex.getStatus().value())
            .message(ex.getReason())
            .build(),
        ex.getStatus());
  }
}
