package com.example.EndpointProtecion.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter@Setter
public class CreateUser {
    private Integer siNo;
    private String userName;
    private String userRole;
    private String userEmail;
    private Integer userSalary;
    private String userJob;
    private String userDept;
    private String password;
}
