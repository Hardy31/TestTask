package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;
import ru.test.task.entity.Account;

import java.sql.Timestamp;

@Getter
@ToString
public class TransactionDtoCreate {

    private Long id;

    private String type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private Timestamp createdAt;

    private double transferAmount;

    private String debitAccountId;

    private String creditAccountId;
}
