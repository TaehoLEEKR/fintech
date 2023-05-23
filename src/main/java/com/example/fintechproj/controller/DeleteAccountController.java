package com.example.fintechproj.controller;

import com.example.fintechproj.application.AccountApplication;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.service.DeleteAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/del")
@RequiredArgsConstructor
public class DeleteAccountController {

    private final DeleteAccountService deleteAccountService;
    @DeleteMapping("/account")
    public ResponseEntity<Account> deleteAccount(@RequestParam String accountNum){
        deleteAccountService.deleteAccount(accountNum);
        return ResponseEntity.ok().build();
    }
}
