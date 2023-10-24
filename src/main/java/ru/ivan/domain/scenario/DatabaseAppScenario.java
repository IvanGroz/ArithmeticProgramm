package ru.ivan.domain.scenario;

import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.domain.usecase.CalculateOperationUseCase;
import ru.ivan.domain.usecase.GetOperationUseCase;

import java.sql.SQLException;
import java.util.List;

public class DatabaseAppScenario {
  private final GetOperationUseCase getOperationUseCase;
  private final CalculateOperationUseCase calculateOperationUseCase;

  public DatabaseAppScenario(GetOperationUseCase getOperationUseCase,
                             CalculateOperationUseCase calculateOperationUseCase) {
    this.getOperationUseCase = getOperationUseCase;
    this.calculateOperationUseCase = calculateOperationUseCase;
  }

  public void invoke() throws SQLException {
   List<CalculationResult> list = calculateOperationUseCase.invoke(getOperationUseCase.invoke());
  }
}
