package ru.ivan.data.datasource;

import ru.ivan.data.model.OperationModel;
import ru.ivan.domain.entity.Operation;

import java.sql.SQLException;
import java.util.List;

public interface OperationDataSource {
  List<OperationModel> getAll() ;

}
