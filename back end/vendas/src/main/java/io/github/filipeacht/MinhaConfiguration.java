package io.github.filipeacht;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@Profile("development")
@DevelopmentConfig
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.print("RODANDO A CONFIGURACAO DE DESENVOLVIMENTO");
        };
    }
    /*@Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas com Bean";
    }*/
}
