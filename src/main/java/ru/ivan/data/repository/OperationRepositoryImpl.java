package ru.ivan.data.repository;

import ru.ivan.data.converter.OperationConverter;
import ru.ivan.data.datasource.OperationDataSource;
import ru.ivan.domain.entity.Operation;
import ru.ivan.domain.repository.OperationRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class OperationRepositoryImpl implements OperationRepository {
  private final OperationDataSource dataSource;
  private final OperationConverter converter;

  public OperationRepositoryImpl(OperationDataSource dataSource, OperationConverter converter) {
    this.dataSource = dataSource;
    this.converter = converter;
  }

  @Override
  public List<Operation> getAll()  {
    return dataSource.getAll().stream().map(converter::convert).collect(Collectors.toList());
  }
}
