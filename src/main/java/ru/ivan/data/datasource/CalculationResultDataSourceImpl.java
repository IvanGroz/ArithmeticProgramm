package ru.ivan.data.datasource;

import ru.ivan.data.database.Database;
import ru.ivan.domain.entity.CalculationResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CalculationResultDataSourceImpl implements CalculationResultDataSource{
  private final Database database;
  private final String SQL_QUERY_SAVE_RESULTS = "INSERT INTO result VALUES (%d,%s);";

  public CalculationResultDataSourceImpl(Database database) {this.database = database;}

  @Override
  public void saveAll(List<CalculationResult> calculationResults) throws SQLException {
    for (CalculationResult result:calculationResults) {
      String sql = formatSqlQuery(result);
      try{
        ResultSet rs = database.execute(sql);
        rs.close();
      }
      catch (SQLException e){
        if(!e.getSQLState().equals("02000")){throw e;}

      }
    }
  }
  private String formatSqlQuery(CalculationResult calculationResult){
    return String.format(SQL_QUERY_SAVE_RESULTS, calculationResult.getId(),calculationResult.getResult());
  }
}
