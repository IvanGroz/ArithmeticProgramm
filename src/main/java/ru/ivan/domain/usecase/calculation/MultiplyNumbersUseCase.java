package ru.ivan.domain.usecase.calculation;

import java.util.Arrays;

public class MultiplyNumbersUseCase {
  public Float invoke(Float [] args){
    return Arrays.stream(args).reduce(1f,(a,b)-> a * b);
  }
}
