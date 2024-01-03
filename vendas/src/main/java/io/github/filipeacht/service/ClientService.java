package io.github.filipeacht.service;

import io.github.filipeacht.model.Client;
import io.github.filipeacht.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository repository;

    @Autowired
    public ClientService( ClientRepository repository){
        this.repository = repository;
    }
    public void saveClient(Client client){
        checkClient(client);
        this.repository.persist(client);
    }

    public void checkClient(Client client){
        // aplicar validações
    }
}
