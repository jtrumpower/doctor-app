package com.josiah.doctorapp.controller.model.request;

import com.josiah.doctorapp.service.enums.RowTypeEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SearchRequestEnum extends SearchRequest {
  private RowTypeEnum rowType;
}
