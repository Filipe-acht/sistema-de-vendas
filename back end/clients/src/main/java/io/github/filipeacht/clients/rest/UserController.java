package io.github.filipeacht.clients.rest;

import io.github.filipeacht.clients.exception.UserExistsException;
import io.github.filipeacht.clients.model.entity.ClientUser;
import io.github.filipeacht.clients.model.repository.UserRepository;
import io.github.filipeacht.clients.service.ClientUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {

    private final ClientUserService clientUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid ClientUser clientUser) {
        try {
            clientUserService.save(clientUser);
        } catch (UserExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
