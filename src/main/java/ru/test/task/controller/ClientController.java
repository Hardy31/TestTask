package ru.test.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.test.task.dto.ClientDtoTransfer;
import ru.test.task.dto.ClientDto;
import ru.test.task.dto.ClientDtoCreate;
import ru.test.task.service.ClientService;

import java.util.List;

@Slf4j
@RestController
//@Api (discription = "Пример работы Swager")
@RequiredArgsConstructor
@RequestMapping("/rest/clients")

public class ClientController {
    private final ClientService clientService;

//    curl -X GET http://localhosy/rest/clients
    @GetMapping("")
    public List<ClientDto> getAllClients(){
        log.info("ClientController geAllClients()");
        List<ClientDto> allClients = clientService.getAllClients();
        return allClients;
    }

//    curl -v http://localhost:8080/rest/clients/1

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable Long id){
        log.info("ClientController getById(Long id) - {}", id);
        ClientDto clientDto = clientService.getById(id);
        return clientDto;
    }

    @GetMapping("/phone/{phone}")
    public ClientDto getByPhone(@PathVariable String phone){
        log.info("ClientController getByPhone( String phone) - {}", phone);
        ClientDto clientDto = clientService.getByPhone(phone);
        return clientDto;
    }

    @GetMapping("/email/{email}")
    public ClientDto getByEmail(@PathVariable String email){
        log.info("ClientController getByEmail( String email) - {}", email);
        ClientDto clientDto = clientService.getByEmail(email);
        return clientDto;
    }

    @PostMapping("")
    public ClientDto create(@RequestBody ClientDtoCreate clientDtoCreate) {
        log.info("ClientController create  = {}", clientDtoCreate);
        return clientService.create(clientDtoCreate);
    }

    @PutMapping("")
    public ClientDto editClient(@RequestBody ClientDto clientDto) {
        log.info("ClientController editClient  = {}", clientDto);
        return clientService.editClient(clientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id) {
        log.info("ClientController deleteClientById = {}", id);
        clientService.delite(id);
    }

//    @PostMapping("/transfer")
//    public ClientDto transfer(@RequestBody ClientDtoTransfer clientDtoTransfer) {
//        log.info("ClientController create  = {}", clientDtoTransfer);
//        return clientService.transfer(clientDtoTransfer);
//    }
//
//    @PostMapping("/cash_out")
//    public ClientDto cashOut(@RequestBody ClientDto clientDto) {
//        log.info("ClientController create  = {}", clientDto);
//        return clientService.cashOut(clientDto);
//    }
//
//    @PostMapping("/cashe_put")
//    public ClientDto cashePut(@RequestBody ClientDto clientDto) {
//        log.info("ClientController create  = {}", clientDto);
//        return clientService.cashePut(clientDto);
//    }

}
