package com.josiah.doctorapp.helper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.josiah.doctorapp.api.constants.Constants.Column;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import com.josiah.doctorapp.controller.model.request.Sorting;
import com.josiah.doctorapp.service.mapper.SortMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
class PageableHelperTest {

  @Mock
  private SortMapper sortMapper;

  @InjectMocks
  private PageableHelper sut;

  @Test
  void shouldCreatePageableFromSearchRequest() {
    // given
    List<Sorting> sorting = List.of(
        Sorting.builder()
            .sort("desc")
            .field(Column.CHANGE_TYPE)
            .build());
    List<Sort.Order> sorts = List.of(
        Sort.Order.desc(Column.CHANGE_TYPE));
    SearchRequestJdbc search = SearchRequestJdbc.builder()
        .columns(Column.CHANGE_TYPE)
        .page(0)
        .pageSize(25)
        .sorting(sorting)
        .build();

    given(sortMapper.mapSortingToSort(sorting)).willReturn(sorts);

    // when
    Pageable actual = sut.createPageable(search);

    // then
    assertThat(actual.getOffset()).isEqualTo(search.getPage());
    assertThat(actual.getPageSize()).isEqualTo(search.getPageSize());
    assertThat(actual.getSort().get()).contains(sorts.get(0));
  }

  @Test
  void shouldNotCreateSortNotWhitelisted() {
    // given
    List<Sorting> sorting = List.of(
        Sorting.builder()
            .sort("desc")
            .field("bad_column_name")
            .build());

    SearchRequestJdbc search = SearchRequestJdbc.builder()
        .columns(Column.CHANGE_TYPE)
        .page(0)
        .pageSize(25)
        .sorting(sorting)
        .build();

    given(sortMapper.mapSortingToSort(Collections.emptyList())).willReturn(new ArrayList<>());

    // when
    Pageable actual = sut.createPageable(search);

    // then
    assertThat(actual.getOffset()).isEqualTo(search.getPage());
    assertThat(actual.getPageSize()).isEqualTo(search.getPageSize());
    assertThat(actual.getSort().get()).isEmpty();
  }
}
