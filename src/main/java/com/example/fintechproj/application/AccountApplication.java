package com.example.fintechproj.application;


import com.example.fintechproj.domain.form.AccountForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.domain.repository.UserRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountApplication {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Transactional
    public Account CreateAccount(AccountForm form , String email, String token){


        Optional<User> user = userRepository.findByUserEmailAndUserName(email, form.getAccountName());

        if(!user.get().getToken().equals(token)){
            throw new UserException(ErrorCode.TOKEN_VERIFICATION_ERROR);
        }
        else if(!user.isPresent()){
            throw new UserException(ErrorCode.NOT_FOUND_EMAIL);
        }else if(user.get().getAccountCnt() >= 3){
            throw new UserException(ErrorCode.FULL_ACCOUNT_HAVING);
        }
        else{
            String accountNumber = getRandomAccountNumber();
//            if(accountRepository.findByAccountNum(accountNumber).isPresent()){
//                throw new UserException(ErrorCode.ALREADY_ACCOUNT_NUMBER);
//            }
            Account account = accountRepository.save(Account.from(form));
            account.setAccountNum((accountNumber));
            account.setBalance("1");
            return account;
        }
    }
    public String getRandomAccountNumber(){
        return "1111-" + RandomStringUtils.random(5,false,true)
                +"-" +RandomStringUtils.random(5,false,true);
    }

    public List<Account> AccountListSelect(String accountName){
        List<Account> accountList= new ArrayList<Account>();
        Optional<User> user = userRepository.findByUserName(accountName);
        for (int i = 0; i <user.get().getAccountCnt() ; i++) {
            accountList.add(accountRepository.findByAccountName(accountName).get(i));
        }
        return accountList;
    }
    public String BalanceListSelect(String accountNum){
        return accountRepository.findByAccountNum(accountNum).get().getBalance();
    }



}
