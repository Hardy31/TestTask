package ru.test.task.mapper;

import org.mapstruct.Mapper;
import ru.test.task.dto.EmailDto;
import ru.test.task.entity.Email;

import java.sql.Timestamp;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    EmailDto convertToDto (Email email);
    Email convertToEntity (EmailDto emailDto);

    List<EmailDto> convertEmailListToEmailDtoList (List<Email> emailList);
    List<Email> convertEmailDtoListToEmailList(List<EmailDto> emailDtoList);
}
