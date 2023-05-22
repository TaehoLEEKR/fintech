package com.example.fintechproj.service;

import com.example.fintechproj.application.SearchAccountApplication;
import com.example.fintechproj.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchAccountService {
    private final SearchAccountApplication searchAccountApplication;
    public List<Account> searchAccountList(String accountName){
        return searchAccountApplication.searchAccountListSelect(accountName);
    }
    public String searchBalance(String accountNum){
        return searchAccountApplication.searchBalanceListSelect(accountNum);
    }
}
