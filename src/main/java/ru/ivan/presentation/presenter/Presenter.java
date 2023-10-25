package ru.ivan.presentation.presenter;

import ru.ivan.domain.entity.Operation;
import ru.ivan.domain.scenario.ConsoleAppScenario;
import ru.ivan.presentation.view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Presenter implements ConsoleListener {
  private final ConsoleView view;
  private final ConsoleAppScenario consoleAppScenario;

  public Presenter(ConsoleView view, ConsoleAppScenario consoleAppScenario) {
    this.view = view;
    this.consoleAppScenario = consoleAppScenario;
    this.view.addListener(this);
    view.requestData();
  }

  public void onConsoleWrite(String[] args) {
    List<Float> numbers = new ArrayList<>();
    if (args[0].equals("q")) {
      return;
    }
    for (String s : Arrays.copyOfRange(args, 1, args.length)) {
      try {numbers.add(Float.parseFloat(s));} catch (NumberFormatException e) {
        view.printData("Неверный формат ввода. Формат: имя_команды число число");
        view.requestData();
        return;
      }
    }
    Operation operation = new Operation(0, args[0], numbers.toArray(Float[]::new));
    String result;
    try {
      result =
              Float.toString(
                      consoleAppScenario.invoke(
                              new ArrayList<>(List.of(operation)
                              )
                                        ).getResult()
              );
    } catch (NullPointerException e) {result = "Нет такой команды";}
    view.printData(result);
    view.requestData();
  }


}
