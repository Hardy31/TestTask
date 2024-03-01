package ru.test.task.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;
import ru.test.task.entity.Client;
import ru.test.task.mapper.ClientMapper;
import ru.test.task.ripository.ClientRepository;
import ru.test.task.ripository.EmailRepository;
import ru.test.task.ripository.PhonePepository;
import ru.test.task.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImp implements ClientService {
//    @Autowired
    private final ClientRepository clientRepository;
    private  final  ClientMapper clientMapper;
    private final PhonePepository phonePepository;
    private final EmailRepository emailRepository;


    @Override
    public List<ClientDto> getAllClients() {
        List<Client> ClientList = clientRepository.findAll();
//        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        log.info("ClientServiceImp getAllClients()) {}", ClientList);

        return null;
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("ClientServiceImp Клиент не найден Id")
        );
        log.info("ClientServiceImp getById(Long id) {}", client);
        ClientDto clientDto = clientMapper.convertToDto(client);
        return clientDto;
    }

    @Override
    public ClientDto create(ClientDtoCreate clientDtoCreate) {
        return null;
    }

    @Override
    public ClientDto editClieny(ClientDto clientDto) {
        return null;
    }

    @Override
    public void delite(long id) {

    }

    @Override
    public ClientDto getByEmail(String email) {
        return null;
    }

    @Override
    public ClientDto getByPhone(String phone) {
        return null;
    }
}
