package com.example.fintechproj.service;

import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUserIdAndUserEmail(Long id, String email){
        return userRepository.findById(id)
                .stream()
                .filter(
                        user -> user.getUserEmail().equals(email)
                ).findFirst();
    }
    public Optional<User> findValidUser(String email ,String pw){
        return userRepository.findByUserEmail(email).stream().filter(
                user -> user.getUserPw().equals(pw) && user.isEmailVerified()
        ).findFirst();
    }
}
