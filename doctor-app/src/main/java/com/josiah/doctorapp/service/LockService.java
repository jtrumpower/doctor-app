package com.josiah.doctorapp.service;

import com.josiah.doctorapp.data.entity.LockEntity;
import java.util.List;

public interface LockService {
  List<LockEntity> getLocks();
  void deleteLock(long id);
}
