package ru.test.task.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;

import java.util.List;

public interface ClientService  {


    List<ClientDto> getAllClients();

    ClientDto getById(Long id);

    ClientDto create(ClientDtoCreate clientDtoCreate);

    ClientDto editClient(ClientDto clientDto);

    void delite(@PathVariable long id);

    ClientDto getByEmail(String email);

    ClientDto getByPhone(String phone);
}
