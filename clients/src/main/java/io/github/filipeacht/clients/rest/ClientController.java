package io.github.filipeacht.clients.rest;

import io.github.filipeacht.clients.model.entity.Client;
import io.github.filipeacht.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid Client client){
        return repository.save(client);
    }

    @GetMapping("{id}")
    public Client findClientById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!") );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable Integer id ){
        repository
                .findById(id)
                .map(client -> {
                    repository.delete(client);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatingClient(@PathVariable Integer id, @RequestBody @Valid Client updatedClient){
        repository
                .findById(id)
                .map( client -> {
                    client.setName(updatedClient.getName());
                    client.setCpf(updatedClient.getCpf());
                    return repository.save(updatedClient);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!") );
    }
}