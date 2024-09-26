package com.example.spring_oauth2_authorization_server.repository;

import com.example.spring_oauth2_authorization_server.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterEntity, String> {

    Optional<RegisterEntity> findByClientId(String clientId);
}
