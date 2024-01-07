package io.github.filipeacht.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    /*@Bean
    public CommandLineRunner run(@Autowired ClientRepository repository){
        return args ->{
            Client client = Client.builder().cpf("01234567891").name("Stahlmann").build();
            repository.save(client);
        };
    }*/

    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);
    }
}