package com.example.spring_oauth2_authorization_server.service;

import com.example.spring_oauth2_authorization_server.dto.UserDTO;
import com.example.spring_oauth2_authorization_server.entity.UserEntity;
import com.example.spring_oauth2_authorization_server.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 회원 가입 프로세스
    public void join(UserDTO dto) {

        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setNickname(dto.getUsername());
        entity.setPhone(dto.getPhone());
        entity.setRole("ADMIN");

        userRepository.save(entity);
    }
}
