package ru.ivan.domain.usecase.calculation;

public class MultiplyPlusAddNumbersUseCase {
  public Float invoke(Float[] args){
    return args[0]*args[1]+args[2];
  }
}
