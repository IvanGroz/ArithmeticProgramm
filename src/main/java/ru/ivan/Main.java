package ru.ivan;

import ru.ivan.data.converter.OperationConverter;
import ru.ivan.data.database.Database;
import ru.ivan.data.datasource.CalculationResultDataSourceImpl;
import ru.ivan.data.datasource.OperationDataSourceImpl;
import ru.ivan.data.repository.CalculationResultRepositoryImpl;
import ru.ivan.data.repository.OperationRepositoryImpl;
import ru.ivan.domain.scenario.ConsoleAppScenario;
import ru.ivan.domain.scenario.DatabaseAppScenario;
import ru.ivan.domain.usecase.CalculateOperationUseCase;
import ru.ivan.domain.usecase.GetOperationUseCase;
import ru.ivan.domain.usecase.SaveCalculationResultUseCase;
import ru.ivan.presentation.presenter.Presenter;
import ru.ivan.presentation.view.ConsoleMainView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
  private final static String CONSOLE_MODE = "-";
  private final static String DATABASE_MODE = "db";
  private static Database DATABASE;

  static { //Нужно для инициализации БД файлом извне
    final String FILENAME = "db_prop.txt";
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME,
                                                                           StandardCharsets.UTF_8
    ))) {

      String user = bufferedReader.readLine();
      String passw = bufferedReader.readLine();
      String url = bufferedReader.readLine();
      DATABASE = new Database(user, passw, false, url);
    } catch (FileNotFoundException e) {
      System.out.println("Для подключения к БД небходимо чтобы рядом с jar-файлом лежал '" + FILENAME + "', " + "где:\n1я строка - это имя пользователя\n2я - пароль\n3я - url подключения " + "формата: 'jdbc:postgresql://localhost:5432/db_name' ");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private final static DatabaseAppScenario DATABASE_APP_SCENARIO =
          new DatabaseAppScenario(
                  new GetOperationUseCase(
                          new OperationRepositoryImpl(
                                  new OperationDataSourceImpl(DATABASE),
                                  new OperationConverter()
                          )
                  ),
                  new CalculateOperationUseCase(),
                  new SaveCalculationResultUseCase(
                          new CalculationResultRepositoryImpl(
                                  new CalculationResultDataSourceImpl(DATABASE)
                          )
                  )
          );

  public static void main(String[] args) {
    String appMode = "";
    try {//считываем режим работы
      appMode = args[0];
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Не указаны аргументы!");
    }
    switch (appMode) {
      case CONSOLE_MODE:
        final ConsoleMainView CONSOLE_MAIN_VIEW = new ConsoleMainView();
        new Presenter(CONSOLE_MAIN_VIEW, new ConsoleAppScenario(new CalculateOperationUseCase()));
        break;
      case DATABASE_MODE:
        try {
          DATABASE.connect();
          DATABASE_APP_SCENARIO.invoke();
          DATABASE.disconnect();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        break;
      default:
        if (args.length != 2) {
          System.out.println("При файловом режиме работы,аргументов программы должно быть 2:" +
                                     " входной файл и файл печати");
        }
        break;
    }
  }
}