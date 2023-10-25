package ru.ivan.domain.usecase;

import ru.ivan.domain.entity.Operation;
import ru.ivan.domain.repository.OperationRepository;

import java.sql.SQLException;
import java.util.List;

public class GetOperationUseCase {
  private final OperationRepository operationRepository;

  public GetOperationUseCase(OperationRepository operationRepository) {
    this.operationRepository = operationRepository;
  }
  public List<Operation> invoke(){
    return operationRepository.getAll();
  }
}
