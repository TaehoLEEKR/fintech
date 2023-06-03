package com.example.fintechproj.application;

import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchAccountApplication {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    public List<Account> searchAccountListSelect(String accountName){
        List<Account> accountList= new ArrayList<Account>();
        Optional<User> user = userRepository.findByUserName(accountName);
        for (int i = 0; i <user.get().getAccountCnt() ; i++) {
            accountList.add(accountRepository.findByAccountName(accountName).get(i));
        }
        return accountList;
    }
    public String searchBalanceListSelect(String accountNum){
        return accountRepository.findByAccountNum(accountNum).get().getBalance();
    }
}
