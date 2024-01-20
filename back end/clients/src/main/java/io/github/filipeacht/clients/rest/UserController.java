package io.github.filipeacht.clients.rest;

import io.github.filipeacht.clients.model.entity.User;
import io.github.filipeacht.clients.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid User user) {
        userRepository.save(user);
    }
}
