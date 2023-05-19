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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateAccountApplication {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

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
            Optional<Account> saving = accountRepository.findByAccountName(form.getAccountName());
            saving.get().setAccountNum(Long.valueOf(accountNumber));
            return account;
        }
    }
    public String getRandomAccountNumber(){
        return "1111" + RandomStringUtils.random(10,false,true);
    }


}
