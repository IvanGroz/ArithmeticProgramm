package ru.ivan.presentation.view;

import ru.ivan.presentation.presenter.ConsoleListener;

public interface ConsoleView {
  void addListener(final ConsoleListener listener);
  void requestData();
  void printData(String print);
}
