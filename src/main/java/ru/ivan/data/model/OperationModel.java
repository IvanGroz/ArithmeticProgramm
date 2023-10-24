package ru.ivan.data.model;

public class OperationModel {
  public final long id;
  public final String type;
  public final Float[] args;

  public OperationModel(long id, String type, Float[] args) {
    this.id = id;
    this.type = type;
    this.args = args;
  }
}
