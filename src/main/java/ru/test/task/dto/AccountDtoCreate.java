package ru.test.task.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountDtoCreate {
    private String name;
    private double balance;
    private ClientDto clientDto;
}
