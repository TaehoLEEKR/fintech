package com.example.fintechproj.service;

import com.example.fintechproj.application.CreateAccountApplication;
import com.example.fintechproj.domain.form.AccountForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CreateAccountService {

    private final CreateAccountApplication createAccountApplication;

    // 계좌 생성
    public Account CreateSaveAccount(AccountForm form , String email,String token){

        return createAccountApplication.CreateAccount(form,email,token);
    }



}
