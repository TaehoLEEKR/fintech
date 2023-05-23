package com.example.fintechproj.service;

import com.example.fintechproj.application.AccountApplication;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteAccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public void deleteAccount(String accountNum){
        Account account = accountRepository.findByAccountNum(accountNum)
                .orElseThrow(()-> new UserException(ErrorCode.NOT_HAVING_ACCOUNT_NUMBER));
        accountRepository.delete(account);
    }
}
