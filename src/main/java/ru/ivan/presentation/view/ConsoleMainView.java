package ru.ivan.presentation.view;

import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.presentation.presenter.ConsoleListener;

import java.lang.reflect.Array;
import java.util.*;

public class ConsoleMainView implements ConsoleView {
  private final List<ConsoleListener> listeners;
  private final String START_APP_STRING =
          "В данном консольном приложении поддерживаниется 4 вида оперпаций:\n" +
                  "1) Сложение 2х и более чисел (add)\n" +
                  "2) Умножение 2х и более чисел (mul)\n" +
                  "3) Умножение первых 2х чисел и сложение с 3м числом (mul_add)\n " +
                  "4) Извлечение корня (sqrt)\n" +
                  "Для выхода q";


  public ConsoleMainView() {
    System.out.println(START_APP_STRING);
    this.listeners = new ArrayList<>();

  }
  public void requestData(){
    Scanner in = new Scanner(System.in);

    System.out.print("> ");
    String[] args = in.nextLine().split(" ");

    for (ConsoleListener l:listeners) {
      l.onConsoleWrite(args);
    }
  }
  public void printData(String calculationResult){
    System.out.println("Результат вычисления: " + calculationResult);
  }
  @Override
  public void addListener(final ConsoleListener listener) {
    listeners.add(listener);
  }
}
