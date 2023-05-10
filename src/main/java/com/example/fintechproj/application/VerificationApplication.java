package com.example.fintechproj.application;

import com.example.fintechproj.service.VerificationSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationApplication {
    private final VerificationSignUpService verificationSignUpService;

    public void userVerify(String email , String code){
        verificationSignUpService.verifyEmail(email,code);
    }


}
