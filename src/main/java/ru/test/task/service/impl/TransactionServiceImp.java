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

@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final AccountRepository accountRepository;
    @Override
    @Transactional
    public TransactionDto create(TransactionDtoCreate transactionDtoCreate) {

        Account debitAccount;
        Account creditAccount;
        Transaction transaction;
        Transaction save;
        TransactionDto result = null;


        log.info("__TransactionServiceImp  transactionDtoCreate__ {}", transactionDtoCreate);
        TransactionType type = TransactionType.valueOf(transactionDtoCreate.getType());
        Timestamp currentTimeStamp = new Timestamp(new Date().getTime());

        if ((transactionDtoCreate.getCreditAccountId() == null) & (transactionDtoCreate.getType().equals(TransactionType.PUT.toString()))) {
            debitAccount = accountRepository.findById(Long.parseLong(transactionDtoCreate.getDebitAccountId())).get();
            debitAccount.setBalance(debitAccount.getBalance() + transactionDtoCreate.getTransferAmount());
            transaction = new Transaction(null, type, currentTimeStamp, transactionDtoCreate.getTransferAmount(), debitAccount, null);
            save = transactionRepository.save(transaction);
             result = transactionMapper.convertToDto(save);

        }

        if ((transactionDtoCreate.getDebitAccountId() == null) & (transactionDtoCreate.getType().equals(TransactionType.WITHDRAWAL.toString()))) {
            creditAccount = accountRepository.findById(Long.parseLong(transactionDtoCreate.getCreditAccountId())).get();
            if (creditAccount.getBalance() < transactionDtoCreate.getTransferAmount()) {
                throw new RuntimeException("!! недостаточно средств на счете!!!");
            } else {
                creditAccount.setBalance(creditAccount.getBalance() - transactionDtoCreate.getTransferAmount());
                transaction = new Transaction(null, type, currentTimeStamp, transactionDtoCreate.getTransferAmount(), null, creditAccount);
                save = transactionRepository.save(transaction);
                result = transactionMapper.convertToDto(save);

            }
        }


        if (transactionDtoCreate.getType().equals(TransactionType.TRANSFER.toString())) {
            creditAccount = accountRepository.findById(Long.parseLong(transactionDtoCreate.getCreditAccountId())).get();
            debitAccount = accountRepository.findById(Long.parseLong(transactionDtoCreate.getDebitAccountId())).get();
            if (creditAccount.getBalance() < transactionDtoCreate.getTransferAmount()) {
                throw new RuntimeException("!! недостаточно средств на счете!!!");
            }
            debitAccount.setBalance(debitAccount.getBalance() + transactionDtoCreate.getTransferAmount());
            creditAccount.setBalance(creditAccount.getBalance() - transactionDtoCreate.getTransferAmount());
            transaction = new Transaction(null, type, currentTimeStamp, transactionDtoCreate.getTransferAmount(), debitAccount, creditAccount);
            save = transactionRepository.save(transaction);
             result = transactionMapper.convertToDto(save);

        }
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
        log.info("__TransactionServiceImp  transactionList__ getAll() {}", transactionList);
        List<TransactionDto> result = transactionMapper.convertTransactionListToTransactionDtoList(transactionList);
        log.info("__TransactionServiceImp  transactionDtoList getAll() {}", result);
        return result;
    }
}
