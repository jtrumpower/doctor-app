package com.josiah.doctorapp.data.repository;

import static com.josiah.doctorapp.data.constant.QueryConstants.WHERE_NAME;
import static org.hibernate.jpa.QueryHints.HINT_CACHEABLE;
import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;
import static org.hibernate.jpa.QueryHints.HINT_READONLY;

import com.josiah.doctorapp.data.entity.GeneralEntity;
import java.util.stream.Stream;
import javax.persistence.QueryHint;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
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

  @Query(value = "select * from general_data",
      countQuery = "SELECT COUNT(*) FROM general_data",
      nativeQuery = true)
  Page<GeneralEntity> getAllNative(Pageable pageable);

  @Query(value = "select * from general_data " + WHERE_NAME,
      countQuery = "SELECT count(*) FROM general_data " + WHERE_NAME,
      nativeQuery = true)
  Page<GeneralEntity> getByName(@Param("val") String val, Pageable pageable);
}
