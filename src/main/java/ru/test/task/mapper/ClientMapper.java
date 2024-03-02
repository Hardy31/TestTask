package ru.test.task.mapper;

import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;
import ru.test.task.entity.Client;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",  imports = Timestamp.class)
public interface ClientMapper {


//    @Mapping(source = "client.phone", target = "phone")
//    @Mapping(source = "client.email", target = "email")
    ClientDto convertToDto (Client client);
    Client convertToEntity (ClientDto clientDto);

    List<ClientDto> convertClientListToClientDtoList (List<Client> clientList);

    Client createToEntity(ClientDtoCreate clientDtoCreate);

}
