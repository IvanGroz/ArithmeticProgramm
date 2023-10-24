package ru.ivan.presentation.presenter;

import ru.ivan.presentation.view.ConsoleView;

public class Presenter implements ConsoleListener{
  private final ConsoleView view;

  public Presenter(ConsoleView view) {
    this.view = view;
    this.view.addListener(this);
  }

  public void onConsoleWrite() {
    System.out.println("Получил данные");
  }
}
