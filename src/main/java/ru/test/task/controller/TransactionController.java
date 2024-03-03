package ru.test.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;
import ru.test.task.dto.TransactionDto;
import ru.test.task.dto.TransactionDtoCreate;
import ru.test.task.ripository.TransactionRepository;
import ru.test.task.service.TransactionService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/transactions")
public class TransactionController {
    private  final TransactionService transactionService;
    @GetMapping("")
    public List<TransactionDto> getAllTransaction(){
        log.info("TransactionController getAllTransaction()");
        List<TransactionDto> allTransaction = transactionService.getAll();
        return allTransaction;
    }


    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable Long id){
        log.info("TransactionController getById(@PathVariable Long id) - {}", id);
        TransactionDto transactionDto = transactionService.getById(id);
        return transactionDto;
    }
    @PostMapping("")
    public TransactionDto create(@RequestBody TransactionDtoCreate transactionDtoCreate) {
        log.info("ClientController create  = {}", transactionDtoCreate);
        TransactionDto transactionDto = transactionService.create(transactionDtoCreate);
        return transactionDto;
    }
}
