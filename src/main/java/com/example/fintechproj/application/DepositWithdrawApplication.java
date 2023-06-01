package com.example.fintechproj.application;

import com.example.fintechproj.domain.form.DepositForm;
import com.example.fintechproj.domain.form.WithdrawForm;
import com.example.fintechproj.domain.model.Account;
import com.example.fintechproj.domain.model.Deposit;
import com.example.fintechproj.domain.model.Withdraw;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.domain.repository.DepositRepository;
import com.example.fintechproj.domain.repository.WithdrawRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepositWithdrawApplication {
    // 입금
    // 인출
    private final AccountRepository accountRepository;
    private final DepositRepository depositRepository;
    private final WithdrawRepository withdrawRepository;

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
    public String depositAmount(DepositForm form){
        depositRepository.save(Deposit.from(form));
        if(!checkAccountNumber(form.getAccountNum())){
            throw new UserException(ErrorCode.NOT_HAVING_ACCOUNT_NUMBER);
        }else if(!checkAmountIsDigit(form.getDpAmount())) {
            throw new UserException(ErrorCode.WRONG_AMOUNT_MONEY);
        }else{
                Optional<Account> account = accountRepository.findByAccountNum(form.getAccountNum());

                String amountMoney = form.getDpAmount();
                Long balance= Long.valueOf(account.get().getBalance());
                Long depositBalance = Long.valueOf(amountMoney);

                account.get().setBalance(String.valueOf(balance + depositBalance));

                return "입금 금액 " + amountMoney + "원 " +"계좌 번호 : "+ form.getAccountNum() + " 입금 되었습니다.";
            }
        }
    @Transactional
    public String withdrawAmount(WithdrawForm form){
        withdrawRepository.save(Withdraw.from(form));

        Optional<Account> account = accountRepository.findByAccountNum(form.getAccountNum());

        String amountMoney = form.getWdAmount();
        Long balance= Long.valueOf(account.get().getBalance());
        Long withdrawBalance = balance - Long.valueOf(amountMoney);
        if(!checkAccountNumber(form.getAccountNum())){
            throw new UserException(ErrorCode.NOT_HAVING_ACCOUNT_NUMBER);
        }else if(!checkAmountIsDigit(form.getWdAmount()))
        {
            throw new UserException(ErrorCode.WRONG_AMOUNT_MONEY);
        }
        else if(withdrawBalance<0){
            throw new UserException(ErrorCode.MINUS_BALANCE_MONEY);
        }else{
            account.get().setBalance(String.valueOf(withdrawBalance));
            return "출금 금액 " + amountMoney + "원" + "계좌 번호 : " + form.getAccountNum() + "출금 되었습니다."
                    + " 현재 잔액 : " + account.get().getBalance();
        }
    }
}
