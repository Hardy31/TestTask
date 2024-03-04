package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import ru.test.task.entity.Account;
import ru.test.task.entity.enums.TransactionType;

import java.sql.Timestamp;


//@NoArgsConstructor
//@AllArgsConstructor
//@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
//@ToString
//@Getter
@Value
public class TransactionDto {

     Long id;

     String type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
     Timestamp createdAt;

     double transferAmount;

     Account debitAccount;

     Account creditAccount;

}
