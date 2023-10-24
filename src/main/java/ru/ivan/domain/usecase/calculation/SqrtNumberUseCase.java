package ru.ivan.domain.usecase.calculation;

public class SqrtNumberUseCase {
  public Float invoke(Float[] args){
    return ((float) Math.sqrt(args[0]));
  }
}
