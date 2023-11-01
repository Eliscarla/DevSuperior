package com.dessafiocrud.Desafio.services;

import com.dessafiocrud.Desafio.dto.ClientDto;
import com.dessafiocrud.Desafio.entities.Client;
import com.dessafiocrud.Desafio.repositories.ClientRepository;
import com.dessafiocrud.Desafio.services.exception.DataBaseException;
import com.dessafiocrud.Desafio.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    @Transactional
    public ClientDto insertClient(ClientDto clientDto) {
       Client client = new Client();
       copyClientDtoClient(clientDto, client);
       clientRepository.save(client);
       return clientDto ;
   }
    @Transactional(readOnly = true)
    public Page<ClientDto> getClient(Pageable pageable) {
       Page<Client> clients = clientRepository.findAll(pageable);
       return clients.map(x -> new ClientDto(x));
   }

   @Transactional(readOnly = true)
   public ClientDto getClientById(Long id){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        );
        return new ClientDto(client);
   }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }
        try{
            clientRepository.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataBaseException("Falha na integridade referencial!");
        }
    }

    @Transactional
    public ClientDto updateClient(Long id, ClientDto clientDto){

        try {
            Client client = clientRepository.getReferenceById(id);
            copyClientDtoClient(clientDto, client);
            client = clientRepository.save(client);
            return new ClientDto(client);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id não encontrado");
        }

    }

    private void copyClientDtoClient(ClientDto clientDto, Client client) {
        client.setCpf(clientDto.getCpf());
        client.setName(clientDto.getName());
        client.setIncome(clientDto.getIncome());
        client.setBirthDate(clientDto.getBirthDate());
        client.setChildren(clientDto.getChildren());
    }
}
