package ru.ivan.data.datasource;

import ru.ivan.domain.entity.CalculationResult;

import java.sql.SQLException;
import java.util.List;

public interface CalculationResultDataSource {
  void saveAll(List<CalculationResult> calculationResults) ;
}
