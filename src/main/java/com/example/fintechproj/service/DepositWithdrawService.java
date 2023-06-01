package com.example.fintechproj.service;

import com.example.fintechproj.application.DepositWithdrawApplication;
import com.example.fintechproj.domain.form.DepositForm;
import com.example.fintechproj.domain.form.WithdrawForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepositWithdrawService {
    private final DepositWithdrawApplication depositWithdrawApplication;
    public String depositSystem(DepositForm form){
        return depositWithdrawApplication.depositAmount(form);
    }
    public String withdrawSystem(WithdrawForm form){
        return depositWithdrawApplication.withdrawAmount(form);
    }
}
