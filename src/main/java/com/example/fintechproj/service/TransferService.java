package com.example.fintechproj.service;

import com.example.fintechproj.application.TransferApplication;
import com.example.fintechproj.domain.form.TransferForm;
import com.example.fintechproj.domain.model.Transfer;
import com.example.fintechproj.domain.repository.AccountRepository;
import com.example.fintechproj.domain.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransferApplication transferApplication;
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;
    public String transferAccountSer(TransferForm form){
        return transferApplication.transferFunction(form);
    }
    public List<String> searchTransferAccountSer(String accountNum){
        List<Transfer> transferList =transferRepository.findBySenderAccountNum(accountNum);

        List<String> lst = new ArrayList<>();
        for (int i = 0; i <transferList.size() ; i++) {
            lst.add(transferList.get(i).getSenderAccountNum());
            lst.add(String.valueOf(transferList.get(i).getTransferDt()));
            lst.add(String.valueOf(accountRepository.findByAccountNum(transferList.get(i).getReceiveAccountNum()).get().getAccountNum()));
            lst.add(transferList.get(i).getTfAmount());
        }
        
    return lst;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Scheduled(cron ="* 10 * * * *") // 10분만다 주기
    public void bookingTransferAccount(TransferForm form , LocalDate date){
        if(date.isEqual(LocalDate.now())){
            transferApplication.transferFunction(form);
        }
    }
}
