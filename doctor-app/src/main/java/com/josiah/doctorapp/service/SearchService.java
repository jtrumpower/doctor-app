package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.response.SearchResponse;
import com.josiah.doctorapp.data.entity.GeneralEntity;
import com.josiah.doctorapp.data.repository.GeneralRepository;
import com.josiah.doctorapp.service.mapper.GeneralRowMapper;
import com.josiah.doctorapp.service.model.GeneralRow;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

  private final GeneralRepository repository;
  private final GeneralRowMapper mapper;

  public SearchResponse search(String name, int pageSize) {
    Page<GeneralEntity> pageResults = repository.findByPhysicianFirstNameLikeOrPhysicianLastNameLike(
        name,
        name,
        PageRequest.of(0, pageSize));

    return SearchResponse.builder()
        .totalPages(pageResults.getTotalPages())
        .totalResults(pageResults.getTotalElements())
        .results(pageResults.getContent()
            .stream()
            .map(mapper::mapGeneralRowToEntity)
            .collect(Collectors.toList()))
        .build();
  }
}
