package com.example.fintechproj.service;

import com.example.fintechproj.application.SignInApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final SignInApplication signInApplication;

    public String userLoginToken(String email ,String pw){
        return signInApplication.loginToken(email,pw);
    }
}
