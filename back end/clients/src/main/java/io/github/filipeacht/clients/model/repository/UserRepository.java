package io.github.filipeacht.clients.model.repository;


import io.github.filipeacht.clients.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
