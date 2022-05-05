package com.josiah.doctorapp.data.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_data")
public class GeneralEntity {
  @Id
  @Column
  private UUID id;

  @Column
  private String firstName;

  @Column
  private String lastName;
}
