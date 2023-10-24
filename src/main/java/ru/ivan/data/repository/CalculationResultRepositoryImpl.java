package ru.ivan.data.repository;

import ru.ivan.data.datasource.CalculationResultDataSource;
import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.domain.repository.CalculationResultRepository;

import java.sql.SQLException;
import java.util.List;

public class CalculationResultRepositoryImpl implements CalculationResultRepository {
  private final CalculationResultDataSource dataSource;

  public CalculationResultRepositoryImpl(
          CalculationResultDataSource dataSource) {this.dataSource = dataSource;}

  @Override
  public void saveAll(List<CalculationResult> calculationResults) throws SQLException {
    dataSource.saveAll(calculationResults);
  }
}