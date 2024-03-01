package ru.test.task.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.test.task.dto.AccountDto;
import ru.test.task.dto.AccountDtoCreate;
import ru.test.task.dto.ClientDto;
import ru.test.task.service.AccountService;

import java.util.List;

@Service
//@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiseImp implements AccountService {
    @Override
    public List<ClientDto> getAllAccounts() {
        return null;
    }

    @Override
    public ClientDto getById(Long id) {
        return null;
    }

    @Override
    public ClientDto create(AccountDtoCreate accountDtoCreate) {
        return null;
    }

    @Override
    public ClientDto editAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public void delite(long id) {

    }
}
