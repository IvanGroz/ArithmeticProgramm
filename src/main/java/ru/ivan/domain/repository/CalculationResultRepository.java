package ru.ivan.domain.repository;

import ru.ivan.domain.entity.CalculationResult;

import java.sql.SQLException;
import java.util.List;

public interface CalculationResultRepository {
  void saveAll(List<CalculationResult> calculationResults) ;
}
