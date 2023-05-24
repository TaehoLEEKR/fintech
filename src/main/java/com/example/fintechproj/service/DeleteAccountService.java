package com.example.fintechproj.service;

import com.example.fintechproj.application.AccountApplication;
import com.example.fintechproj.application.VerificationApplication;
import com.example.fintechproj.domain.form.SignUpForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.domain.repository.UserRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteAccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final VerificationApplication verificationApplication;
    @Transactional
    public String deleteAccount(String accountNum, String email){
        Optional<User> user = userRepository.findByUserEmail(email);

        accountRepository.findByAccountNum(accountNum) .orElseThrow(()-> new UserException(ErrorCode.NOT_HAVING_ACCOUNT_NUMBER));

        return verificationApplication.sendDeleteEmailVerification(email ,user.get().getUserName(),accountNum);

    }

    public void deleteAccountVerify(String email, String code,String accountNum) {
        if(verificationApplication.isDeleteVerifyEmail(email,code,accountNum)){
            Account account = accountRepository.findByAccountNum(accountNum)
                    .orElseThrow(()-> new UserException(ErrorCode.NOT_HAVING_ACCOUNT_NUMBER));
            accountRepository.delete(account);
        }
    }
}
