package com.example.EndpointProtecion.Exception;

public class UserAlredyExistsException extends RuntimeException {
    public UserAlredyExistsException(String message) {
        super(message);
    }
}
