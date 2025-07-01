package com.example.EndpointProtecion.Service;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.SingleUserDTO;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Exception.UserAlredyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    public List<UserDTO> getAllUsers();

    public SingleUserDTO createUser(CreateUser newUser) throws UserAlredyExistsException;

    public SingleUserDTO findUserById(UUID id);
}
