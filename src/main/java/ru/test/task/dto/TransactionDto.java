package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.test.task.entity.Account;
import ru.test.task.entity.enums.TransactionType;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionDto {

    private Long id;

    private String type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private Timestamp createdAt;

    private double transferAmount;

    private Account debitAccount;

    private Account creditAccount;

}
