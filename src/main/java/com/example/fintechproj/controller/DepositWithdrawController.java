package com.example.fintechproj.controller;

import com.example.fintechproj.domain.form.DepositForm;
import com.example.fintechproj.domain.form.WithdrawForm;
import com.example.fintechproj.service.DepositWithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepositWithdrawController {
    private final DepositWithdrawService depositWithdrawService;
    @PostMapping("/deposit")
    public ResponseEntity<String> depositAccount(DepositForm form){
        return ResponseEntity.ok(depositWithdrawService.depositSystem(form));
    }
    @PutMapping("/withdraw")
    public ResponseEntity<String> withdrawAccount(WithdrawForm form){
        return ResponseEntity.ok(depositWithdrawService.withdrawSystem(form));
    }

}
