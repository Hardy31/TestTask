package ru.test.task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.TransactionDto;
import ru.test.task.entity.Client;
import ru.test.task.entity.Transaction;

import java.sql.Timestamp;
import java.util.List;
@Mapper(componentModel = "spring",  imports = Timestamp.class)
public interface TransactionMapper {
    @Mapping(source = "transactions.transferAmount", target = "transferAmount")
    TransactionDto convertToDto (Transaction transaction);
    @Mapping(target = "createdAt", expression = "java(new Timestamp(System.currentTimeMillis()))")
    Transaction convertToEntity (TransactionDto transactionDto);
    List<TransactionDto> convertTransactionListToTransactionDtoList (List<Transaction> transactionList);

}
