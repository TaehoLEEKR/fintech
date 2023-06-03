package com.example.fintechproj.controller;


import com.example.fintechproj.service.DeleteAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/del")
@RequiredArgsConstructor
public class DeleteAccountController {

    private final DeleteAccountService deleteAccountService;
    @PostMapping("/account")
    public ResponseEntity<String> deleteAccount(@RequestParam String accountNum, @RequestParam String email){
        return ResponseEntity.ok(deleteAccountService.deleteAccount(accountNum,email));
    }
    @GetMapping("/user")
    public ResponseEntity<String> verifyDeleteAccount(@RequestParam String email,@RequestParam String code, @RequestParam String accountNum){
        deleteAccountService.deleteAccountVerify(email,code,accountNum);
        return ResponseEntity.ok("계좌 삭제 완료 되었습니다.");
    }
}
