package ru.ivan.data.repository;

import ru.ivan.domain.entity.CalculationResult;
import ru.ivan.domain.repository.CalculationResultRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CalculationResultRepositoryFileImpl implements CalculationResultRepository {
  private final String FILENAME;

  public CalculationResultRepositoryFileImpl(String filename) {FILENAME = filename;}

  @Override
  public void saveAll(List<CalculationResult> calculationResults) {
    PrintWriter writer;
    try {
      writer = new PrintWriter(FILENAME, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    for (CalculationResult result:calculationResults){
      writer.println(result.getResult());
    }
    writer.close();

  }
}
