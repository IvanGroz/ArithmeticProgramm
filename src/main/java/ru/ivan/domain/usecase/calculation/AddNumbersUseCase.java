package ru.ivan.domain.usecase.calculation;

import java.util.Arrays;

public class AddNumbersUseCase {
  public Float invoke(Float[] args){
    return Arrays.stream(args).reduce(0f,Float::sum);
  }
}
