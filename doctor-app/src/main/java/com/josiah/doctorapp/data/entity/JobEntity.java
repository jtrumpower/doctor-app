package com.josiah.doctorapp.data.entity;

import com.josiah.doctorapp.job.enums.JobStatus;
import com.josiah.doctorapp.job.enums.JobType;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", columnDefinition = "varchar(64)")
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", columnDefinition = "varchar(15)")
  private JobType jobType;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "varchar(20)")
  private JobStatus jobStatus;

  @Column(name = "status_desc", columnDefinition = "mediumtext")
  private String statusDesc;

  @Column(name = "description", columnDefinition = "varchar(255)")
  private String description;

  @CreatedDate
  @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
  private Timestamp created;

  @Column(name = "completed", columnDefinition = "timestamp null")
  private Timestamp completed;

  @Column(name = "took", columnDefinition = "varchar(15)")
  private long took;
}
