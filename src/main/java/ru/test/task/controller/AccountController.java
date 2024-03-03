package ru.test.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.test.task.dto.AccountDto;
import ru.test.task.dto.AccountDtoCreate;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;
import ru.test.task.service.AccountService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/accounts")
public class AccountController {
    private final AccountService accountService;
    @GetMapping("")
    public List<AccountDto> getAllAccount(){
        log.info("AccountController getAllAccount()");
        List<AccountDto> allAccount = accountService.getAll();
        return allAccount;
    }

//    curl -v http://localhost:8080/rest/clients/1

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable Long id){
        log.info("AccountController getById(@PathVariable Long id) - {}", id);
        AccountDto accountDto = accountService.getById(id);

        return accountDto;
    }

//    @PostMapping("")
//    public AccountDto create(@RequestBody AccountDtoCreate accountDtoCreate) {
//        log.info("AccountController create  = {}", accountDtoCreate);
//        return accountService.create(accountDtoCreate);
//    }
    @PutMapping("")
    public AccountDto editClient(@RequestBody AccountDto accountDto) {
        log.info("AccountController editClient  = {}", accountDto);
        return accountService.editAccount(accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("AccountController deleteById = {}", id);
        accountService.delite(id);
    }
}
