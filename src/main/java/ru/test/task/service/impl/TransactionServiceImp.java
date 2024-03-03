package ru.test.task.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.test.task.dto.TransactionDto;
import ru.test.task.dto.TransactionDtoCreate;
import ru.test.task.entity.Account;
import ru.test.task.entity.Transaction;
import ru.test.task.entity.enums.TransactionType;
import ru.test.task.mapper.TransactionMapper;
import ru.test.task.ripository.AccountRepository;
import ru.test.task.ripository.TransactionRepository;
import ru.test.task.service.TransactionService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final AccountRepository accountRepository;
    @Override
    public TransactionDto create(TransactionDtoCreate transactionDtoCreate) {
        log.info("__TransactionServiceImp  transactionDtoCreate__ {}", transactionDtoCreate);
        TransactionType type = TransactionType.valueOf(transactionDtoCreate.getType());
        Timestamp currentTimeStamp = new Timestamp(new Date().getTime());
        Account debitAccount = accountRepository.findById(Long.parseLong(transactionDtoCreate.getDebitAccountId())).get();
        Account creditAccount = accountRepository.findById(Long.parseLong(transactionDtoCreate.getCreditAccountId())).get();
        Transaction transaction = new Transaction(null, type, currentTimeStamp, transactionDtoCreate.getTransferAmount(),  creditAccount, debitAccount);
        Transaction save = transactionRepository.save(transaction);
        TransactionDto result = transactionMapper.convertToDto(save);
        return result;
    }

    @Override
    public TransactionDto getById(Long id) {
        Transaction save = transactionRepository.findById(id).get();
        log.info("__TransactionServiceImp  transactionDtoCreate__ save {}", save);
        TransactionDto result = transactionMapper.convertToDto(save);
        log.info("__TransactionServiceImp  transactionDtoCreate__ result {}", result);
        return result;
    }

    @Override
    public List<TransactionDto> getAll() {

        List<Transaction> transactionList = transactionRepository.findAll();
        List<TransactionDto> result = transactionMapper.convertTransactionListToTransactionDtoList(transactionList);
        return result;
    }
}
