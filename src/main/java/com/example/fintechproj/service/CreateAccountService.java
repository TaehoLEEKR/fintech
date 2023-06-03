package com.example.fintechproj.service;

import com.example.fintechproj.application.AccountApplication;
import com.example.fintechproj.domain.form.AccountForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class CreateAccountService {

    private final AccountApplication createAccountApplication;
    private final UserRepository userRepository;
    // 계좌 생성
    @Transactional
    public Account CreateSaveAccount(AccountForm form , String email,String token){
        Account account = createAccountApplication.CreateAccount(form,email,token);
        int userAccountCnt = userRepository.findByUserEmail(email).get().getAccountCnt();
        userRepository.findByUserEmail(email).get().setAccountCnt(++userAccountCnt);

        return account;
    }



}
