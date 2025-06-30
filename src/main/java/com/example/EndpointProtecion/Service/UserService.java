package com.example.EndpointProtecion.Service;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Exception.UserAlredyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public UserDTO createUser(CreateUser newUser) throws UserAlredyExistsException;
}
