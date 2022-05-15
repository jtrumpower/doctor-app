package com.josiah.doctorapp.job;

import com.josiah.doctorapp.data.entity.JobEntity;
import com.josiah.doctorapp.data.entity.LockEntity;
import com.josiah.doctorapp.data.repository.JobRepository;
import com.josiah.doctorapp.data.repository.LockRepository;
import com.josiah.doctorapp.job.enums.JobStatus;
import com.josiah.doctorapp.job.enums.TableEnum;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public abstract class Job<T> {
  protected final LockRepository lockRepository;
  protected final JobRepository jobRepository;

  protected abstract void runJob(T params);
  protected abstract JobEntity insertJob(T params);

  @Transactional
  public void run(T params) {
    LocalDateTime start = LocalDateTime.now();
    JobEntity job = insertJob(params);
    lockTable(TableEnum.GENERAL_DATA, job);

    ForkJoinPool.commonPool()
        .execute(() -> {
          try {
            runJob(params);
            updateJob(job, JobStatus.SUCCESS, "Successfully complete job", start);
          } catch (Exception e) {
            updateJob(job, JobStatus.FAILED, e.getMessage(), start);
            throw e;
          } finally {
            unlockTable(job.getId());
          }
        });
  }

  private void updateJob(JobEntity job, JobStatus status, String message, LocalDateTime start) {
    job.setJobStatus(status);
    job.setStatusDesc(message);
    job.setCompleted(new Timestamp(Calendar.getInstance().getTimeInMillis()));
    job.setTook(ChronoUnit.SECONDS.between(start,  LocalDateTime.now()));
    jobRepository.save(job);
  }

  protected void lockTable(TableEnum table, JobEntity job) {
    if (lockRepository.findByTable(table).isPresent()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, String.format("Lock already exists on table: %s", table));
    }
    lockRepository.save(
        LockEntity.builder()
            .table(table)
            .job(job)
            .build());
  }

  protected void unlockTable(long jobId) {
    lockRepository.findByJob_id(jobId)
        .ifPresent(lockRepository::delete);

  }
}
