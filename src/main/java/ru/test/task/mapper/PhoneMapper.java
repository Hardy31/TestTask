package ru.test.task.mapper;

import org.mapstruct.Mapper;
import ru.test.task.dto.EmailDto;
import ru.test.task.dto.PhoneDto;
import ru.test.task.entity.Email;
import ru.test.task.entity.Phone;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    PhoneDto convertToDto (Phone phone);
    Phone convertToEntity (PhoneDto phoneDto);

    List<PhoneDto> convertPhoneListToPhoneDtoList (List<Phone> phoneList);
    List<Phone> convertPhoneDtoListToPhoneList(List<PhoneDto> phoneDtoList);
}
