package ru.ivan.presentation.view;

import ru.ivan.presentation.presenter.ConsoleListener;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMainView implements ConsoleView {
  private final List<ConsoleListener> listeners;
  private final String START_APP_STRING =
          "В данном консольном приложении поддерживаниется 4 вида оперпаций:\n" +
                  "1) Сложение 2х и более чисел (add)\n" +
                  "2) Умножение 2х и более чисел (mul)\n" +
                  "3) Умножение первых 2х чисел и сложение с 3м числом (mul_add)\n " +
                  "4) Извлечение корня\n";


  public ConsoleMainView() {
    System.out.println(START_APP_STRING);
    this.listeners = new ArrayList<ConsoleListener>();
  }

  @Override
  public void addListener(final ConsoleListener listener) {
    listeners.add(listener);
  }
}
