package com.example.EndpointProtecion.Mapper;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.SingleUserDTO;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Entity.UserEntity;
import com.example.EndpointProtecion.Utils.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {
    public final String defaultRole = "user";
    public final boolean defaultIsActive = false;

    @Autowired
    public PasswordEncoding encoder;

    //    create user to user entity converter
    public UserEntity createToEntity(CreateUser newUser) {
        if (newUser == null) {
            return null;
        }
        return UserEntity.builder().
                id(newUser.getId()).
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

    //    convert user entity to single user DTO
    public SingleUserDTO userToSingleDTO(UserEntity user) {
        if (user == null) {
            return null;
        }

        return SingleUserDTO.builder().
                id(user.getId()).
                userName(user.getUserName()).
                userSalary(user.getUserSalary()).
                userDept(user.getUserDept()).
                userJob(user.getUserJob()).
                userEmail(user.getUserEmail()).
                userRole(user.getUserRole()).build();
    }

    //    create user to single user DTO
    public void createToSingleUserDTO(CreateUser newUser) {
        if (newUser == null) {
            return;
        }
        SingleUserDTO.builder().
                id(newUser.getId()).
                userName(newUser.getUserName()).
                userSalary(newUser.getUserSalary()).
                userDept(newUser.getUserDept()).
                userJob(newUser.getUserJob()).
                userEmail(newUser.getUserEmail()).
                userRole(Objects.equals(newUser.getUserRole(), "") || newUser.getUserRole() == null ? defaultRole : newUser.getUserRole()).
                userIsActive(defaultIsActive).build();
    }
}
