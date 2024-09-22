package com.example.spring_oauth2_authorization_server.service;

import com.example.spring_oauth2_authorization_server.entity.UserEntity;
import com.example.spring_oauth2_authorization_server.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 스프링 시큐리티 회원 가입 규격 UserDetailsService 구현
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity entity = userRepository.findByUsername(username).orElseThrow();

        UserDetails userDetails = User.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .roles(entity.getRole())
                .build();

        return userDetails;
    }
}
