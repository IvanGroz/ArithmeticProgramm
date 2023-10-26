package ru.ivan.domain.scenario;

import ru.ivan.domain.usecase.CalculateOperationUseCase;
import ru.ivan.domain.usecase.GetOperationUseCase;
import ru.ivan.domain.usecase.SaveCalculationResultUseCase;

public class FileAppScenario {
  private final GetOperationUseCase getOperationUseCase;
  private final CalculateOperationUseCase calculateOperationUseCase;
  private final SaveCalculationResultUseCase saveCalculationResultUseCase;
  public FileAppScenario(GetOperationUseCase getOperationUseCase,
                         CalculateOperationUseCase calculateOperationUseCase,
                         SaveCalculationResultUseCase saveCalculationResultUseCase) {
    this.getOperationUseCase = getOperationUseCase;
    this.calculateOperationUseCase = calculateOperationUseCase;
    this.saveCalculationResultUseCase = saveCalculationResultUseCase;
  }

  public void invoke() {
    saveCalculationResultUseCase.invoke(calculateOperationUseCase.invoke(getOperationUseCase.invoke()));
  }
}
