package com.josiah.doctorapp.data.entity;

import com.josiah.doctorapp.job.enums.TableEnum;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "locks")
public class LockEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "locked_table", columnDefinition = "varchar(64)")
  private TableEnum table;

  @OneToOne
  @JoinColumn(name = "job_id")
  private JobEntity job;

  @CreatedDate
  @Column(name = "created", columnDefinition = "timestamp")
  private Timestamp created;
}
