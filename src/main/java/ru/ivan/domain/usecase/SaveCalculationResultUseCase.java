package ru.ivan.domain.usecase;

import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.domain.repository.CalculationResultRepository;

import java.util.List;

public class SaveCalculationResultUseCase {
  private final CalculationResultRepository calculationResultRepository;

  public SaveCalculationResultUseCase(CalculationResultRepository calculationResultRepository) {
    this.calculationResultRepository = calculationResultRepository;
  }

  public void invoke(List<CalculationResult> calculationResults) {
    calculationResultRepository.saveAll(calculationResults);
  }
}
