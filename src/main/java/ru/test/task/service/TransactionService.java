package ru.test.task.service;

import ru.test.task.dto.TransactionDto;
import ru.test.task.dto.TransactionDtoCreate;

import java.util.List;

public interface TransactionService {

    TransactionDto create(TransactionDtoCreate transactionDtoCreate);
    TransactionDto getById(Long id);
    List<TransactionDto> getAll();



}
