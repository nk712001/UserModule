package com.example.EndpointProtecion.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleUserDTO {
    private UUID id;
    private String userName;
    private String userRole;
    private Integer userSalary;
    private String userEmail;
    private String userJob;
    private String userDept;
    private boolean userIsActive;

    @Override
    public String toString() {
        return userName + "userName:- " + " userEmail:- " + userEmail + " userIsActive:- " + userIsActive + " userRole:- " + userRole + " userSalary:- " + userSalary + " userJob:- " + userJob + " userDept:- " + userDept;
    }
}
