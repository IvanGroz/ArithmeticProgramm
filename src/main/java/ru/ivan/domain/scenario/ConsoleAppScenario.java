package ru.ivan.domain.scenario;

import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.domain.entity.Operation;
import ru.ivan.domain.usecase.CalculateOperationUseCase;

import java.util.List;

public class ConsoleAppScenario {
  private final CalculateOperationUseCase calculateOperationUseCase;

  public ConsoleAppScenario(
          CalculateOperationUseCase calculateOperationUseCase) {this.calculateOperationUseCase =
          calculateOperationUseCase;}
  public CalculationResult invoke(List<Operation> operationList){
    List<CalculationResult> calculationResults = calculateOperationUseCase.invoke(operationList);
    if(calculationResults.isEmpty()){return null;}
    return calculationResults.get(0);

  }
}
