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
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
public abstract class Job<T> {
  protected final LockRepository lockRepository;
  protected final JobRepository jobRepository;

  protected abstract void runJob(T params);
  protected abstract JobEntity insertJob(T params);

  @Async
  public void run(T params) {
    LocalDateTime start = LocalDateTime.now();
    JobEntity job = insertJob(params);
    lockTable(TableEnum.GENERAL_DATA, job);

    try {
      runJob(params);
      updateJob(job, JobStatus.SUCCESS, "Successfully complete job", start);
    } catch (Exception e) {
      updateJob(job, JobStatus.FAILED, e.getMessage(), start);
      throw e;
    } finally {
      unlockTable(TableEnum.GENERAL_DATA);
    }
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
      throw new RuntimeException(String.format("Lock already exists on table: %s", table));
    }
    lockRepository.save(
        LockEntity.builder()
            .table(table)
            .job(job)
            .build());
  }

  protected void unlockTable(TableEnum table) {
    lockRepository.delete(
        lockRepository.findByTable(table)
            .orElseThrow(() -> new RuntimeException(String.format("No to delete for table: %s", table.name()))));
  }
}
