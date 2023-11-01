package com.dessafiocrud.Desafio.controllers;

import com.dessafiocrud.Desafio.dto.ClientDto;
import com.dessafiocrud.Desafio.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<ClientDto>> getClient (Pageable pageable) {
        Page<ClientDto> clientDtos = clientService.getClient(pageable);
        return ResponseEntity.ok(clientDtos) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id){
        ClientDto clientDto = clientService.getClientById(id);
        return ResponseEntity.ok(clientDto);
    }

    @PostMapping
    public ResponseEntity<ClientDto> insertClient(@Valid @RequestBody ClientDto clientDto){
        clientService.insertClient(clientDto) ;
        return ResponseEntity.created(URI.create("http://teste")).body(clientDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDto clientDto ){
        ClientDto clientDtoAux = clientService.updateClient(id, clientDto);
        return  ResponseEntity.ok(clientDtoAux);
    }

}
