package ru.ivan.domain.scenario;

import ru.ivan.domain.usecase.CalculateOperationUseCase;
import ru.ivan.domain.usecase.GetOperationUseCase;
import ru.ivan.domain.usecase.SaveCalculationResultUseCase;

import java.sql.SQLException;

public class DatabaseAppScenario {
  private final GetOperationUseCase getOperationUseCase;
  private final CalculateOperationUseCase calculateOperationUseCase;
  private final SaveCalculationResultUseCase saveCalculationResultUseCase;

  public DatabaseAppScenario(GetOperationUseCase getOperationUseCase,
                             CalculateOperationUseCase calculateOperationUseCase,
                             SaveCalculationResultUseCase saveCalculationResultUseCase) {
    this.getOperationUseCase = getOperationUseCase;
    this.calculateOperationUseCase = calculateOperationUseCase;
    this.saveCalculationResultUseCase = saveCalculationResultUseCase;
  }

  public void invoke() throws SQLException {
    saveCalculationResultUseCase.invoke(calculateOperationUseCase.invoke(getOperationUseCase.invoke()));
  }
}
