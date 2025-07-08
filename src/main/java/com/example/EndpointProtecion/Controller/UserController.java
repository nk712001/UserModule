package com.example.EndpointProtecion.Controller;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.SingleUserDTO;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Exception.NoUserFoundForGivenIdException;
import com.example.EndpointProtecion.Mapper.UserMapper;
import com.example.EndpointProtecion.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/users/v1")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public UserService service;

    @Autowired
    public UserMapper mapper;

    @GetMapping("/allUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> getUser() {
        List<UserDTO> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        try {
            SingleUserDTO singleUser = service.findUserById(id);
            return ResponseEntity.ok(singleUser);
        } catch (NoUserFoundForGivenIdException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }


    @PostMapping("/createUser")
    public ResponseEntity<SingleUserDTO> createUser(@RequestBody CreateUser userObj) throws Exception {
        SingleUserDTO user = service.createUser(userObj);
        mapper.createToSingleUserDTO(userObj);
        return ResponseEntity.ok(user);
    }
}
