package com.example.EndpointProtecion.DTO;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    //    private UUID id;
    private Integer siNo;
    private String userName;
    private String userRole;
    private Integer userSalary;
    private String userEmail;
    private String userJob;
    private String userDept;
    private boolean userIsActive;
//    private String password;

    @Override
    public String toString() {
        return "userName:- " + userName + "sino:- " + siNo + " userEmail:- " + userEmail + " userIsActive:- " + userIsActive + " userRole:- " + userRole + " userSalary:- " + userSalary + " userJob:- " + userJob + " userDept:- " + userDept;
    }
}
