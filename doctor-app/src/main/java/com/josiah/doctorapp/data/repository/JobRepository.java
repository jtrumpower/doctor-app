package com.josiah.doctorapp.data.repository;


import com.josiah.doctorapp.data.entity.JobEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {

  @Query("select j from JobEntity j order by j.created desc")
  List<JobEntity> findAllOrderByCreatedDesc();
}
