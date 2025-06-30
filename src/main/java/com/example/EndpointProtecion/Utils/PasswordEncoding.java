package com.example.EndpointProtecion.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoding {
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hashedPassword(String plainPassword) {
        return encoder.encode(plainPassword);
    }

    public boolean verifyCredentials(String plainPassword, String hashedPassword) {
        return encoder.matches(plainPassword, hashedPassword);
    }
}
