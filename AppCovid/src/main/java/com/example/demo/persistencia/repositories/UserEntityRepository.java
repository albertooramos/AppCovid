package com.example.demo.persistencia.repositories;

import java.util.Optional;

import com.example.demo.modelo.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
	Optional<UserEntity> findByUsername(String username);
}
