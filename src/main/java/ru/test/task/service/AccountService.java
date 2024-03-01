package ru.test.task.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.test.task.dto.AccountDto;
import ru.test.task.dto.AccountDtoCreate;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;

import java.util.List;

public interface AccountService {
    List<ClientDto> getAllAccounts();

    ClientDto getById(Long id);

    ClientDto create(AccountDtoCreate accountDtoCreate);

    ClientDto editAccount(AccountDto accountDto);

    void delite(@PathVariable long id);
}
