package ru.ivan.data.datasource;

import ru.ivan.data.model.OperationModel;

import java.util.List;

public interface OperationDataSource {
  List<OperationModel> getAll() ;

}
