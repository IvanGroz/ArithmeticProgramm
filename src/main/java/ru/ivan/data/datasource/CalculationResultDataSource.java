package ru.ivan.data.datasource;

import ru.ivan.domain.entity.CalculationResult;

import java.util.List;

public interface CalculationResultDataSource {
  void saveAll(List<CalculationResult> calculationResults) ;
}
