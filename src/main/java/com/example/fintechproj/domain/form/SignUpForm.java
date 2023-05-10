package com.example.fintechproj.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
    private String userEmail;
    private String userName;
    private String userPw;
    private String phone;

}
