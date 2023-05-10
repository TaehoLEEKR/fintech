package com.example.fintechproj.service;

import com.example.fintechproj.domain.form.SignUpForm;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.UserRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VerificationSignUpService {

    private final UserRepository userRepository;

    @Transactional
    public void verifyEmail(String email, String code) {
        User user = userRepository.findByUserEmail(email).orElseThrow(() -> new UserException(ErrorCode.NOT_FOUND_EMAIL));

        if(user.isEmailVerified()){

        }
    }
    public User verificationSignup(SignUpForm form){
        return userRepository.save(User.from(form));
    }



}
