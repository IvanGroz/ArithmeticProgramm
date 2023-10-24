package ru.ivan.data.datasource;

import ru.ivan.data.database.Database;
import ru.ivan.data.model.OperationModel;
import ru.ivan.domain.entity.Operation;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationDataSourceImpl implements OperationDataSource {
  private final Database database;
  private final String SQL_QUERY_OPERATION = "SELECT * FROM operations;";
  public OperationDataSourceImpl(Database database) {
    this.database = database;
  }

  @Override
  public List<OperationModel> getAll() throws SQLException {
    return convertToOperationModel(database.execute(SQL_QUERY_OPERATION));
  }

  private List<OperationModel> convertToOperationModel(ResultSet resultSet) throws SQLException {
    ArrayList<OperationModel>list = new ArrayList<>();
    while (resultSet.next()){
    long id = resultSet.getLong("id");
    String type = resultSet.getString("type");
    Float [] args = (Float[]) resultSet.getArray("args").getArray();

    list.add(new OperationModel(id,type,args));
    }
    return list;
  }
}