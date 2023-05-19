package com.example.fintechproj.domain.model;

import com.example.fintechproj.domain.form.AccountForm;
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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNum;
    private String accountName;
    private String accountType;
    private String balance;
    private boolean dtEmailVerified;

    public static Account from(AccountForm form){
        return Account.builder()
                .accountName(form.getAccountName())
                .accountType(form.getAccountType())
                .build();
    }
}
