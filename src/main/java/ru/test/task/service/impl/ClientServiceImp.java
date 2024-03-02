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
import ru.test.task.dto.EmailDto;
import ru.test.task.dto.PhoneDto;
import ru.test.task.entity.Client;
import ru.test.task.entity.Email;
import ru.test.task.entity.Phone;
import ru.test.task.mapper.ClientMapper;
import ru.test.task.mapper.EmailMapper;
import ru.test.task.mapper.PhoneMapper;
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

    private final ClientRepository clientRepository;
    private  final  ClientMapper clientMapper;

    private final EmailRepository emailRepository;
    private  final EmailMapper emailMapper;

    private final PhonePepository phonePepository;
    private final PhoneMapper phoneMapper;


    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clientList = clientRepository.findAll();
//        ObjectMapper  = new ObjectMapper().registerModule(new JavaTimeModule());
        log.info("ClientServiceImp getAllClients()) {}", clientList);
        List<ClientDto> clientDtoList = clientMapper.convertClientListToClientDtoList(clientList);
        return clientDtoList;
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("ClientServiceImp Клиент не найден Id")
        );

        log.info("ClientServiceImp getById(Long id) {}", client);
        ClientDto clientDto = clientMapper.convertToDto(client);
        long clientId = client.getId();

        List<Email> emailList = emailRepository.findAllByClient(client);
        List<EmailDto> emailDtoList = emailMapper.convertEmailListToEmailDtoList(emailList);
        clientDto.setEmailDtoList(emailDtoList);

        List<Phone> phoneList = phonePepository.findAllByClient(client);
        List<PhoneDto> phoneDtoList = phoneMapper.convertPhoneListToPhoneDtoList(phoneList);
        clientDto.setPhoneDtoList(phoneDtoList);

        return clientDto;
    }
@Transactional
    @Override
    public ClientDto create(ClientDtoCreate clientDtoCreate) {

        List<EmailDto> emailDtoList =  clientDtoCreate.getEmailDtoList();
        List<PhoneDto> phoneDtoList = clientDtoCreate.getPhoneDtoList();

        ClientDto clientDto = new ClientDto(
                null,
                clientDtoCreate.getFirstName(),
                clientDtoCreate.getLastName(),
                clientDtoCreate.getFatherName(),
                clientDtoCreate.getBirthday(),
                null,
                null
        );
        List<Phone> phoneList = phoneMapper.convertPhoneDtoListToPhoneList(phoneDtoList);
        List<Email> emailList = emailMapper.convertEmailDtoListToEmailList(emailDtoList);
        Client client = clientMapper.convertToEntity(clientDto);

        Client  clientResult = clientRepository.save(client);
        Long id = clientResult.getId();

        phoneList.stream().forEach(x-> x.setClient(client));
        emailList.stream().forEach(x-> x.setClient(client));

        emailRepository.saveAll(emailList);
        phonePepository.saveAll(phoneList);


        return getById(id);
    }

    @Override
    public ClientDto editClient(ClientDto editClientDto) {
        log.info("__ editClient(ClientDto editClientDto) __ {}" , editClientDto);
        Long id = editClientDto.getId();
        Client client = clientRepository.findById(editClientDto.getId()).get();
        //валидация
        client.setFirstName(editClientDto.getFirstName());
        client.setLastName(editClientDto.getLastName());
        client.setFatherName(editClientDto.getFatherName());
        clientRepository.save(client);
        return clientMapper.convertToDto(clientRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void delite(long id) {
        Client client = clientRepository.findById(id).get();
        List<Email> emailList = emailRepository.findAllByClient(client);
        List<Phone> phoneList = phonePepository.findAllByClient(client);
        phonePepository.deleteAll(phoneList);
        emailRepository.deleteAll(emailList);
        clientRepository.delete(client);
    }

    @Override
    public ClientDto getByEmail(String email) {

        Email emailEnt = emailRepository.findByEmail(email);
        Long ClientId = emailEnt.getClient().getId();

        return getById(ClientId);
    }

    @Override
    public ClientDto getByPhone(String phone) {
        System.out.println(phone);
        Phone phoneEnt = phonePepository.findByPhone(phone);
        Long ClientId = phoneEnt.getClient().getId();

        return getById(ClientId);
    }
}
