package com.example.fintechproj.controller;

import com.example.fintechproj.domain.form.AccountForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.service.CreateAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/create")
public class CreateAccountController {

    private final CreateAccountService createAccountService;
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestParam String email ,@RequestBody AccountForm form,@RequestHeader String token){
        Account account = createAccountService.CreateSaveAccount(form, email,token);
        if (account == null){
            return ResponseEntity.ok("사용자 정보를 확인해 주세요");
        }else{
            return ResponseEntity.ok("계좌 생성에 성공하였습니다.");
        }
    }
}
