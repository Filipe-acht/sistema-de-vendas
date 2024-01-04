package io.github.filipeacht.clients;

import io.github.filipeacht.clients.model.entity.Client;
import io.github.filipeacht.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClientRepository repository){
        return args ->{
            Client client = Client.builder().cpf("01234567891").name("Stahlmann").build();
            repository.save(client);
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);
    }
}