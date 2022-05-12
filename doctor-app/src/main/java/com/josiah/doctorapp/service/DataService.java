package com.josiah.doctorapp.service;


import org.springframework.scheduling.annotation.Async;

public interface DataService<T> {
  void process(T param);
}
