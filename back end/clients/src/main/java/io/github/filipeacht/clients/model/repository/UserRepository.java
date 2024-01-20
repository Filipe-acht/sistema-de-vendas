package io.github.filipeacht.clients.model.repository;


import io.github.filipeacht.clients.model.entity.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ClientUser, Integer> {
    Optional<ClientUser> findByUsername(String username);

    boolean existsByUsername(String username);
}
