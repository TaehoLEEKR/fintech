package com.example.fintechproj.controller;


import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.service.SearchAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchAccountController {
    private final SearchAccountService searchAccountService;
    @GetMapping("/account")
    public ResponseEntity<List<Account>> searchAccount(@RequestParam String accountName){
        return ResponseEntity.ok(searchAccountService.searchAccountList(accountName));
    }
    @GetMapping("/balance")
    public ResponseEntity<String> searchBalance( @RequestParam String accountNum){
        return ResponseEntity.ok(searchAccountService.searchBalance(accountNum));
    }
}
