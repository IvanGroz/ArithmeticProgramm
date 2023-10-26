package ru.ivan.domain.repository;

import ru.ivan.domain.entity.Operation;

import java.util.List;

public interface OperationRepository {
  List<Operation> getAll() ;
}
