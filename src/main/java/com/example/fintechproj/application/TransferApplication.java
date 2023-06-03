package com.example.fintechproj.application;

import com.example.fintechproj.domain.form.TransferForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.model.Transfer;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.domain.repository.TransferRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferApplication {
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    public boolean checkAccountNumber(String accountNum){
        return accountRepository.findByAccountNum(accountNum).isPresent();
    }
    public boolean checkAmountIsDigit(String amount){
        boolean isNumeric = false;
        for (int i = 0; i <amount.length(); i++) {
            if(Character.isDigit(amount.charAt(i))){
                isNumeric = true;
            }else {
                isNumeric = false;
            }
        }
        if(!isNumeric){
            return false;
        }else {
            return true;
        }
    }
    @Transactional
    public String transferFunction(TransferForm form){
        Transfer transfer =  transferRepository.save(Transfer.from(form));
        transfer.setTransferDt(LocalDateTime.now());

        Optional<Account> senderAccount = accountRepository.findByAccountNum(form.getSenderAccountNum());

        Long money = Long.valueOf(form.getTfAmount());
        Long senderBalance = Long.valueOf(senderAccount.get().getBalance()) - money;

        Optional<Account> receiveAccount = accountRepository.findByAccountNum(form.getReceiveAccountNum());
        Long receiveBalance = Long.valueOf(receiveAccount.get().getBalance());
        if(!checkAccountNumber(form.getSenderAccountNum())){
            throw new UserException(ErrorCode.NOT_HAVING_ACCOUNT_NUMBER);
        }else if(!checkAmountIsDigit(form.getTfAmount())){
            throw new UserException(ErrorCode.WRONG_AMOUNT_MONEY);
        }else if(senderBalance <0){
            throw new UserException(ErrorCode.MINUS_BALANCE_MONEY);
        }
            senderAccount.get().setBalance(String.valueOf(senderBalance));
            receiveAccount.get().setBalance(String.valueOf(receiveBalance + money));

            return "송금 금액 : " + form.getTfAmount() + " 원" + " 보내는 분 : " + senderAccount.get().getAccountName() +
                    " 송금 계좌 : " + senderAccount.get().getAccountNum() +
                    " 받는 분 : " + receiveAccount.get().getAccountName() +
                    " 보내는 계좌 : " + receiveAccount.get().getAccountNum();
    }
//
}
