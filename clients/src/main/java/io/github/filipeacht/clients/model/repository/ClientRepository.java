package io.github.filipeacht.clients.model.repository;

import io.github.filipeacht.clients.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
