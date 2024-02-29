package ru.test.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.task.service.AccountService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/accounts")
public class AccountController {
    private final AccountService accountService;

}
