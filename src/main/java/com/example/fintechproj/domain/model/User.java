package com.example.fintechproj.domain.model;


import com.example.fintechproj.domain.form.SignUpForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;
    @Column(unique = true)
    private String userEmail;
    private String userPw;
    private String userName;
    private String phone;
    private LocalDateTime ctDate;
    private LocalDateTime dtDate;
    private LocalDateTime mdDate;
    private boolean emailVerified;
    private LocalDateTime verificationDt;
    private String emailVerificationCode;
    private int accountCnt;
    private String token;

    public static User from (SignUpForm form){
        return User.builder()
                .userEmail(form.getUserEmail())
                .userPw(form.getUserPw())
                .userName(form.getUserName())
                .phone(form.getPhone())
                .build();
    }


}
