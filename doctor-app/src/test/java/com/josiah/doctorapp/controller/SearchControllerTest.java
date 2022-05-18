package com.josiah.doctorapp.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.josiah.doctorapp.api.constants.Constants.Column;
import com.josiah.doctorapp.controller.model.request.SearchRequestJdbc;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTest {
  private static final String SEARCH_NAME = "matthew";

  @Autowired
  private MockMvc mockMvc;

  @Test
  @SneakyThrows
  @Sql("classpath:search-data.sql")
  void shouldReturnSearchResults() {
    ObjectMapper objectMapper = new ObjectMapper();
    SearchRequestJdbc search = SearchRequestJdbc.builder()
        .value(SEARCH_NAME)
        .columns(Column.PHYSICIAN_FIRST_NAME)
        .build();

    mockMvc.perform(post("/api/search/paged")
            .content(objectMapper.writeValueAsBytes(search))
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.results", hasSize(1)))
        .andExpect(jsonPath("$.results[0].physician_first_name", is(SEARCH_NAME)));
  }
}
