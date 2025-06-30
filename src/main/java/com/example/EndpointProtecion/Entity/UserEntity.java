package com.example.EndpointProtecion.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserDetails")
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer siNo;
    private String userName;
    private String userRole;
    private String password;
    private Integer userSalary;
    private String userJob;
    private String userEmail;
    private String userDept;
    private boolean userIsActive;

    @Override
    public String toString() {
        return "id:- " + id + "userName:- " + userName + "sino:- " + siNo + " userEmail:- " + userEmail + " userIsActive:- " + userIsActive + " userRole:- " + userRole + " userSalary:- " + userSalary + " userJob:- " + userJob + " userDept:- " + userDept;
    }
}
