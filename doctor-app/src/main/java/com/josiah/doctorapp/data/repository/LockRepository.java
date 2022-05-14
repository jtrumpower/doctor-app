package com.josiah.doctorapp.data.repository;

import com.josiah.doctorapp.data.entity.LockEntity;
import com.josiah.doctorapp.job.enums.TableEnum;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LockRepository extends JpaRepository<LockEntity, Integer> {

  Optional<LockEntity> findByTable(TableEnum Table);

  @Query("select l from LockEntity l order by l.created desc")
  List<LockEntity> getAllLocksOrderByCreatedDesc();
}
