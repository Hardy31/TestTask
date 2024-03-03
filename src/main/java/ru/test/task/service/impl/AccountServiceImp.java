package ru.test.task.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.test.task.dto.AccountDto;
import ru.test.task.dto.AccountDtoCreate;
import ru.test.task.dto.ClientDto;
import ru.test.task.entity.Account;
import ru.test.task.entity.Client;
import ru.test.task.mapper.AccountMapper;
import ru.test.task.mapper.ClientMapper;
import ru.test.task.ripository.AccountRepository;
import ru.test.task.ripository.ClientRepository;
import ru.test.task.service.AccountService;
import ru.test.task.service.ClientService;

import java.util.List;

@Service
//@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImp implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ClientRepository clientRepository;
    private final ClientService clientService;
    private  final ClientMapper clientMapper;
    @Override
    public List<AccountDto> getAll() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountDto> accountDtoList = accountMapper.convertAccountListToAccountDtoList(accountList);
        return accountDtoList;
    }

    @Override
    public AccountDto getById(Long id) {
        Account account = accountRepository.findById(id).get();
        Long clientid = account.getClient().getId();
        Client client = clientRepository.findById(clientid).get();
        account.setClient(client);
        AccountDto result = accountMapper.convertToDto(account);
        ClientDto clientDto = clientMapper.convertToDto(client);
      result.setClientDto(clientDto);

        return result;
    }

    @Override
    public AccountDto create(AccountDtoCreate accountDtoCreate) {
        ClientDto clientDto = accountDtoCreate.getClientDto();
        Long clientId = Long.parseLong(String.valueOf(accountDtoCreate.getClientDto().getId()));
        Client client = clientRepository.findById(clientId).get();
//        Client client  = clientMapper.convertToEntity(clientDto);

        Account account = new Account(
                null,
                accountDtoCreate.getName(),
                accountDtoCreate.getBalance(),
                client
        );
        Account save = accountRepository.save(account);
        AccountDto result = accountMapper.convertToDto(save);

        return result;
    }

    @Override
    public AccountDto editAccount(AccountDto accountDto) {

        Account account = accountMapper.convertToEntity(accountDto);
        Client client = clientRepository.findById(Long.parseLong(String.valueOf(accountDto.getId()))).get();
        account.setClient(client);
        Account save = accountRepository.save(account);
        AccountDto result = accountMapper.convertToDto(save);
        result.setClientDto(clientMapper.convertToDto(client));

        return result;
    }

    @Override
    public void delite(long id) {
        accountRepository.deleteById(id);

    }
}
