package com.josiah.doctorapp.service.mapper;

import com.josiah.doctorapp.controller.model.request.DataloadRequest;
import com.josiah.doctorapp.job.model.FreshLoadDataParam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataLoadMapper {

  FreshLoadDataParam mapFromRequest(DataloadRequest request);
}
