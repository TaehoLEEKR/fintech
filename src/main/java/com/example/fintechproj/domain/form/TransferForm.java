package com.example.fintechproj.domain.form;

import lombok.Data;

@Data
public class TransferForm {
    private String tfAmount;
    private String memo;
    private String senderAccountNum;
    private String receiveAccountNum;
}
