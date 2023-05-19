package com.example.fintechproj.controller;


import com.example.fintechproj.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchAccountController {
    @GetMapping("/account")
    public ResponseEntity<Account> searchAccount(@RequestParam String accountNum, String accountName){
        return null;
    }
}
