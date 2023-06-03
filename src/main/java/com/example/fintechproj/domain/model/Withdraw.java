package com.example.fintechproj.domain.model;

import com.example.fintechproj.domain.form.DepositForm;
import com.example.fintechproj.domain.form.WithdrawForm;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawId;
    private String accountNum;
    private String wdAmount;
    public static Withdraw from(WithdrawForm form){
        return Withdraw.builder()
                .accountNum(form.getAccountNum())
                .wdAmount(form.getWdAmount()).build();
    }

}
