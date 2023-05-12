package com.example.fintechproj.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public enum ErrorCode {



    // 회원 인증
    NOT_FOUND_EMAIL(HttpStatus.BAD_REQUEST,"이메일이 존재 하지 않습니다."),
    ALREADY_EMAIL_VERIFY(HttpStatus.BAD_REQUEST,"이미 이메일 인증하였습니다."),
    WRONG_VERIFICATION_CODE(HttpStatus.BAD_REQUEST,"이메일 인증 코드가 불일치 합니다."),
    EXPIRE_CODE(HttpStatus.BAD_REQUEST,"인증코드 유효기간 1일이 만료되었습니다."),
    ALREADY_EMAIL(HttpStatus.BAD_REQUEST,"이메일이 이미 존재 합니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
