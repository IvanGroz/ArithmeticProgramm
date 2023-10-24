package ru.ivan.domain.entity;

public class Operation {
  private final long id;
  private final String type;
  private final Float[] args;

  public Operation(long id, String type, Float[] args) {
    this.id = id;
    this.type = type;
    this.args = args;
  }

  public long getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public Float[] getArgs() {
    return args;
  }
}
