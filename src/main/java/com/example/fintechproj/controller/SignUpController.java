package com.example.fintechproj.controller;

import com.example.fintechproj.application.VerificationApplication;
import com.example.fintechproj.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final VerificationApplication verificationApplication;

    @PostMapping("/user")
    public ResponseEntity<String> verifyUser(@RequestParam String email ,@RequestParam String code){
        verificationApplication.userVerify(email, code);
        return ResponseEntity.ok("인증이 완료되었습니다.");

    }

}
