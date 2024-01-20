package io.github.filipeacht.clients.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String login) {
        super("User already exist to the login " + login);
    }
}
