package ru.ivan.data.converter;

import ru.ivan.data.model.OperationModel;
import ru.ivan.domain.entity.Operation;

public class OperationConverter {
  public Operation convert(OperationModel operationModel) {
    return new Operation(operationModel.id, operationModel.type, operationModel.args);
  }
}
