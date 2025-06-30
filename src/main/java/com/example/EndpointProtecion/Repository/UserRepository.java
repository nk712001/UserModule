package com.example.EndpointProtecion.Repository;

import com.example.EndpointProtecion.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByUserEmail(String userEmail);

    boolean existsByUserNameAndUserEmail(String userName, String userEmail);

    UserEntity findByUserName(String username);
}
