package ru.test.task.mapper;

import org.mapstruct.Mapper;
import ru.test.task.dto.AccountDto;
import ru.test.task.entity.Account;

import java.sql.Timestamp;
import java.util.List;

@Mapper(componentModel = "spring",  imports = Timestamp.class)
public interface AccountMapper {
    AccountDto convertToDto (Account account);
    Account convertToEntity(AccountDto accountDto);
    List<AccountDto> convertAccountListToAccountDtoList(List<Account> accountList);
}
