package com.josiah.doctorapp.data.repository;


import com.josiah.doctorapp.data.entity.JobEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<JobEntity, Integer> {


}
