package ru.ivan.data.repository;

import ru.ivan.domain.entity.Operation;
import ru.ivan.domain.repository.OperationRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationRepositoryFileImpl implements OperationRepository {
  private final String FILENAME;

  public OperationRepositoryFileImpl(String filename) {FILENAME = filename;}

  @Override
  public List<Operation> getAll() {
    List<Operation> operationList = new ArrayList<>();
    try (BufferedReader bufferedReader =
                 new BufferedReader(
                         new FileReader(FILENAME,
                                        StandardCharsets.UTF_8
                         )
                 )
    ) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] args = line.split(" ");
        List<Float> numbers = new ArrayList<>();
        for (String s : Arrays.copyOfRange(args, 1, args.length)) {
          try {numbers.add(Float.parseFloat(s));} catch (NumberFormatException e) {
            throw new RuntimeException("Неверный формат ввода. Формат: имя_команды число число");
          }
        }
        operationList.add(new Operation(0, args[0],numbers.toArray(Float[]::new) ));
      }

    } catch (FileNotFoundException e) {
      System.out.println("Файл с указанным именем не был найден!\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return operationList;
  }
}
