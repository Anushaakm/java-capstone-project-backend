package com.anu.capstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.capstone.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUserNameAndPassword(String userName, String password);
}
