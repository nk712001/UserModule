package com.example.EndpointProtecion.Exception;

public class NoUserFoundForGivenIdException extends RuntimeException {
    public NoUserFoundForGivenIdException(String message) {
        super(message);
    }

}
