package com.example.fintechproj.service;

import com.example.fintechproj.application.VerificationApplication;
import com.example.fintechproj.domain.form.SignUpForm;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationSignUpService {

    private final VerificationApplication verificationApplication;


    public void userVerify(String email ,String code){
        verificationApplication.isVerifyEmail(email,code);
    }
    public boolean verificationSignup(SignUpForm form){
        if(verificationApplication.isEmailExist(form.getUserEmail())) {
            // 회원가입 폼 작성시 이미 이메일 이 존재하면 에러 출력
            throw new UserException(ErrorCode.ALREADY_EMAIL);
        }else{
            // 이메일이 존재하지않다면 save
            verificationApplication.sendEmailVerification(form);
            return true;
        }
    }
}
