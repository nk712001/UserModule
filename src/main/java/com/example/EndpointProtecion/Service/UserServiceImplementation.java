package com.example.EndpointProtecion.Service;

import com.example.EndpointProtecion.DTO.CreateUser;
import com.example.EndpointProtecion.DTO.SingleUserDTO;
import com.example.EndpointProtecion.DTO.UserDTO;
import com.example.EndpointProtecion.Entity.UserEntity;
import com.example.EndpointProtecion.Exception.NoUserFoundForGivenIdException;
import com.example.EndpointProtecion.Exception.UserAlredyExistsException;
import com.example.EndpointProtecion.Mapper.UserMapper;
import com.example.EndpointProtecion.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);
    private final UserRepository userRepo;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImplementation(UserRepository userRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userList = new ArrayList<>();
        for (UserEntity newUser : userRepo.findAll()) {
            userList.add(mapper.userToDTO(newUser));
        }
        return userList;
    }

    @Transactional
    @Override
    public SingleUserDTO createUser(CreateUser newUser) throws UserAlredyExistsException {
        UserEntity user = mapper.createToEntity(newUser);
        boolean UserFound = userRepo.existsByUserNameAndUserEmail(user.getUserName(), user.getUserEmail()) || userRepo.existsByUserEmail(user.getUserEmail());
        if (UserFound) {
            System.out.println("found");
            throw new UserAlredyExistsException("User Already exits!!! try loggin in");
        } else {
            userRepo.save(user);
            log.info("user details saved to db!!!");
        }
        return mapper.userToSingleDTO(user);
    }

    @Override
    public SingleUserDTO findUserById(UUID id) {
        UserEntity userOpt = userRepo.findById(id).orElseThrow(() -> new NoUserFoundForGivenIdException("No user found for the given ID"));
        return mapper.userToSingleDTO(userOpt);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.getUserName(), user.getPassword(), getAuthorities(user));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(UserEntity user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        return authorities;
    }
}


