package com.josiah.doctorapp.service;

import com.josiah.doctorapp.controller.model.request.SearchRequest;
import com.josiah.doctorapp.controller.model.response.PagedSearchResponse;

public interface SearchService<T extends SearchRequest> {
  PagedSearchResponse pagedSearch(T params);
  PagedSearchResponse search(T params);
}
