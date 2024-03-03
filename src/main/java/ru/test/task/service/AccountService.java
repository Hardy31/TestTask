package ru.test.task.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.test.task.dto.AccountDto;
import ru.test.task.dto.AccountDtoCreate;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();

    AccountDto getById(Long id);

    AccountDto create(AccountDtoCreate accountDtoCreate);

    AccountDto editAccount(AccountDto accountDto);

    void delite(@PathVariable long id);
}
