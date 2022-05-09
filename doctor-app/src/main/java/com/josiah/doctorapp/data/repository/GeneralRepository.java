package com.josiah.doctorapp.data.repository;

import static org.hibernate.jpa.QueryHints.HINT_CACHEABLE;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;
import static org.hibernate.jpa.QueryHints.HINT_READONLY;

import com.josiah.doctorapp.data.entity.GeneralEntity;
import java.util.UUID;
import java.util.stream.Stream;
import javax.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneralRepository extends PagingAndSortingRepository<GeneralEntity, Integer> {

  @Query("select e from GeneralEntity e")
  @QueryHints(value = {
      @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE),
      @QueryHint(name = HINT_CACHEABLE, value = "false"),
      @QueryHint(name = HINT_READONLY, value = "true"),
      @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")
  })
  Stream<GeneralEntity> getAll();

  Page<GeneralEntity> findByPhysicianFirstNameLikeOrPhysicianLastNameLike(String first, String last, Pageable pageable);
}
