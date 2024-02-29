package ru.test.task.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import ru.test.task.entity.Client;

public class AccountDto {
    private Long id;
    private String name;
    private double balance;
    private ClientDto clientDto;
}
