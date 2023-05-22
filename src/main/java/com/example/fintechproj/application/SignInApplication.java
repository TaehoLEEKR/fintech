package com.example.fintechproj.application;

import com.example.config.JwtAuthenticationProvider;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.UserRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import com.example.fintechproj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInApplication {
    private final UserService userService;
    private final JwtAuthenticationProvider provider;

    private final UserRepository userRepository;
    public String loginToken(String email ,String pw){
        User user = userService.findValidUser(email, pw).orElseThrow(
                ()->new UserException(ErrorCode.LOGIN_CHECK_FAIL)
        );
        String token = provider.createToken(user.getUserEmail(), user.getUserId());
        user.setToken(token);
        userRepository.save(user);
        return token;
    }
}
