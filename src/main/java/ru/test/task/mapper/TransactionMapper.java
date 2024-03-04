package ru.test.task.mapper;

import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;
import ru.test.task.dto.TransactionDto;
import ru.test.task.entity.Client;
import ru.test.task.entity.Transaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",  imports = Timestamp.class)
public interface TransactionMapper {

    TransactionDto convertToDto (Transaction transaction);
    @Mapping(target = "createdAt", expression = "java(new Timestamp(System.currentTimeMillis()))")
    Transaction convertToEntity (TransactionDto transactionDto);
    List<TransactionDto> convertTransactionListToTransactionDtoList (List<Transaction> transactionList);

}
