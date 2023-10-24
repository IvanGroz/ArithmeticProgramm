package ru.ivan.domain.usecase;

import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.domain.entity.Operation;
import ru.ivan.domain.usecase.calculation.AddNumbersUseCase;
import ru.ivan.domain.usecase.calculation.MultiplyNumbersUseCase;
import ru.ivan.domain.usecase.calculation.MultiplyPlusAddNumbersUseCase;
import ru.ivan.domain.usecase.calculation.SqrtNumberUseCase;

import java.util.ArrayList;
import java.util.List;

public class CalculateOperationUseCase {
  private final String ADD_CALCULATION = "add";
  private final String MUL_CALCULATION = "mul";
  private final String MUL_ADD_CALCULATION = "mul_add";
  private final String SQRT_CALCULATION = "sqrt";

  public List<CalculationResult> invoke(List<Operation> operationList) {
    List<CalculationResult> list = new ArrayList<>();
    for (Operation operation : operationList) {
      switch (operation.getType()) {
        case ADD_CALCULATION:
          list.add(new CalculationResult(operation.getId(),
                                         new AddNumbersUseCase().invoke(operation.getArgs()
                                         )
                   )
          );
          break;
        case MUL_CALCULATION:
          list.add(new CalculationResult(operation.getId(),
                                         new MultiplyNumbersUseCase().invoke(operation.getArgs()
                                         )
                   )
          );
          break;
        case MUL_ADD_CALCULATION:
          list.add(new CalculationResult(operation.getId(),
                                         new MultiplyPlusAddNumbersUseCase().invoke(operation.getArgs()
                                         )
                   )
          );
          break;
        case SQRT_CALCULATION:
          list.add(new CalculationResult(operation.getId(),
                                         new SqrtNumberUseCase().invoke(operation.getArgs()
                                         )
                   )
          );
          break;
      }

    }
    return list;
  }
}
