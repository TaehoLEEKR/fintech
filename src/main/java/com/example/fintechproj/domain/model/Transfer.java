package com.example.fintechproj.domain.model;

import com.example.fintechproj.domain.form.TransferForm;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long trId;

    private String tfAmount;
    private String memo;
    private String senderAccountNum;
    private String receiveAccountNum;
    private LocalDateTime transferDt;

    public static Transfer from(TransferForm form){
        return Transfer.builder()
                .senderAccountNum(form.getSenderAccountNum())
                .receiveAccountNum(form.getReceiveAccountNum())
                .memo(form.getMemo())
                .tfAmount(form.getTfAmount())
                .build();
    }

}
