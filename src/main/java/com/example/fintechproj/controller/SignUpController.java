package com.example.fintechproj.controller;

import com.example.fintechproj.application.VerificationApplication;
import com.example.fintechproj.domain.form.SignUpForm;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.service.VerificationSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {
    private final VerificationSignUpService verificationSignUpService;


    @GetMapping("/user")
    public ResponseEntity<String> verifyUser(@RequestParam String email ,@RequestParam String code){
        verificationSignUpService.userVerify(email, code);
        return ResponseEntity.ok("인증이 완료되었습니다.");
    }
    @PostMapping
    public ResponseEntity<String> signUpUser(@RequestBody SignUpForm form){ // 회원가입 주소 링크
        return ResponseEntity.ok(verificationSignUpService.verificationSignup(form));
    }

}
