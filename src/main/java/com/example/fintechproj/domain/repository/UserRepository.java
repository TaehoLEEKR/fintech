package com.example.fintechproj.domain.repository;

import com.example.fintechproj.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserEmail(String email);
    Optional<User> findByUserEmailAndUserName(String email ,String UserName);
    Optional<User> findByUserName(String name);



}
