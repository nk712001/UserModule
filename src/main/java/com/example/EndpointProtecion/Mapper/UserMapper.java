package com.example.EndpointProtecion.Mapper;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Entity.UserEntity;
import com.example.EndpointProtecion.Utils.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public final String defaultRole = "user";
    public final boolean defaultIsActive = false;

    @Autowired
    public PasswordEncoding encoder;

    //    create user request to user entity converter
    public UserEntity createToEntity(CreateUser newUser) {
        if (newUser == null) {
            return null;
        }
        return UserEntity.builder().
                userName(newUser.getUserName()).
                password(encoder.hashedPassword(newUser.getPassword())).
                userSalary(newUser.getUserSalary()).
                userDept(newUser.getUserDept()).
                userJob(newUser.getUserJob()).
                userEmail(newUser.getUserEmail()).
                userRole(newUser.getUserRole() != null ? newUser.getUserRole() : defaultRole).
                userIsActive(defaultIsActive).build();
    }

    //    convert user entity to user DTO
    public UserDTO userToDTO(UserEntity user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder().
                userName(user.getUserName()).
                userSalary(user.getUserSalary()).
                userDept(user.getUserDept()).
                userJob(user.getUserJob()).
                userEmail(user.getUserEmail()).
                userRole(user.getUserRole()).build();
    }
}
