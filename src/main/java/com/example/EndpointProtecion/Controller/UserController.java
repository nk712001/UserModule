package com.example.EndpointProtecion.Controller;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Mapper.UserMapper;
import com.example.EndpointProtecion.Service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<UserDTO>> getUser() {
        List<UserDTO> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUser userObj) throws Exception {
        UserDTO user = service.createUser(userObj);
        mapper.createToEntity(userObj);
        return ResponseEntity.ok(user);
    }
}
