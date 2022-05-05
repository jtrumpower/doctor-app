package com.josiah.doctorapp.data.repository;

import com.josiah.doctorapp.data.entity.GeneralEntity;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneralRepository extends JpaRepository<GeneralEntity, UUID> {

  @Query("select e from GeneralEntity e")
  Stream<GeneralEntity> getAll();
}
