package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;
import com.josiah.doctorapp.controller.model.response.SearchResponse;

public interface SearchService<T extends SearchRequest> {
  PagedSearchResponse pagedSearch(T params);
  SearchResponse search(T params);
}
