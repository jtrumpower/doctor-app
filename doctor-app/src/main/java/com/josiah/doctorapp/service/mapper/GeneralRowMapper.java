package com.josiah.doctorapp.service.mapper;

import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.service.model.GeneralRow;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneralRowMapper {

  GeneralEntity mapGeneralRowToEntity(GeneralRow generalRow);
}
