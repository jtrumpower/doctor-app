package com.josiah.doctorapp.service.mapper;

import com.josiah.doctorapp.controller.model.request.Sorting;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

@Mapper(componentModel = "spring")
public abstract class SortMapper {

  public abstract List<Sort.Order> mapSortingToSort(List<Sorting> sorting);

  public Sort.Order mapSortingToOrder(Sorting sorting) {
    return "asc".equals(sorting.getSort())
        ? Order.asc(sorting.getField())
        : Order.desc(sorting.getField());
  }
}
