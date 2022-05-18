package com.josiah.doctorapp.service.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.josiah.doctorapp.service.CsvImportService;
import com.josiah.doctorapp.service.enums.DataLoadType;
import com.josiah.doctorapp.service.impl.DeltaCsvImportService;
import com.josiah.doctorapp.service.impl.FreshCsvImportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CsvImportFactoryTest {

  @Mock
  private FreshCsvImportService freshService;
  @Mock
  private DeltaCsvImportService deltaCsvImportService;

  @InjectMocks
  private CsvImportFactory sut;

  @Test
  void shouldReturnDeltaService() {
    // when
    CsvImportService actual = sut.create(DataLoadType.DELTA);

    // then
    assertThat(actual).isEqualTo(deltaCsvImportService);
  }

  @Test
  void shouldReturnFreshService() {
    // when
    CsvImportService actual = sut.create(DataLoadType.FRESH);

    // then
    assertThat(actual).isEqualTo(freshService);
  }
}
