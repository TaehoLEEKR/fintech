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
    @Column
    private String userPw;
    @Column
    private String userName;
    @Column
    private String phone;
    @Column
    private LocalDateTime ctDate;
    @Column
    private LocalDateTime dtDate;
    @Column
    private LocalDateTime mdDate;
    @Column
    private boolean emailVerified;
    @Column
    private int accountCnt;

    public static User from (SignUpForm form){
        return User.builder()
                .userEmail(form.getUserEmail())
                .userPw(form.getUserPw())
                .userName(form.getUserName())
                .phone(form.getPhone())
                .build();
    }


}
