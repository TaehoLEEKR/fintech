package com.example.fintechproj.controller;

import com.example.fintechproj.service.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signin")
@RequiredArgsConstructor
public class SignInController {
    private final SignInService signInService;

    @PostMapping("/user")
    public ResponseEntity<String> signInUser(@RequestParam String email , String pw){

        String successToken = signInService.userLoginToken(email ,pw);
        return ResponseEntity.ok("로그인 성공하였습니다." + successToken);

    }
}
