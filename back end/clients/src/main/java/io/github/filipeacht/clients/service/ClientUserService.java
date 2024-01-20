package io.github.filipeacht.clients.service;

import io.github.filipeacht.clients.exception.UserExistsException;
import io.github.filipeacht.clients.model.entity.ClientUser;
import io.github.filipeacht.clients.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public ClientUser save(ClientUser clientUser) {
        boolean exists = userRepository.existsByUsername(clientUser.getUsername());
        if (exists) {
            throw new UserExistsException(clientUser.getUsername());
        }
        return userRepository.save(clientUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientUser clientUser = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login doesn't find!"));
        return User
                .builder()
                .username(clientUser.getUsername())
                .password(clientUser.getPassword())
                .roles("USER")
                .build();
    }
}
