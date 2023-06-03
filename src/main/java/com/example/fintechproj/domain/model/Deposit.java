package com.example.fintechproj.domain.model;


import com.example.fintechproj.domain.form.DepositForm;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depositId;

    private String accountNum;
    private String dpAmount;

    public static Deposit from(DepositForm form){
        return Deposit.builder()
                .accountNum(form.getAccountNum())
                .dpAmount(form.getDpAmount()).build();
    }
}
