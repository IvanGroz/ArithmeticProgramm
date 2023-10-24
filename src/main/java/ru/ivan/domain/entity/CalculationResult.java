package ru.ivan.domain.entity;

public class CalculationResult {
  private final long id;
  private final float result;

  public CalculationResult(long id, float result) {
    this.id = id;
    this.result = result;
  }

  public long getId() {
    return id;
  }

  public float getResult() {
    return result;
  }
}
