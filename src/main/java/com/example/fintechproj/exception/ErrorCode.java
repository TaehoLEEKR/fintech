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
    ALREADY_EMAIL(HttpStatus.BAD_REQUEST,"이메일이 이미 존재 합니다."),
    TOKEN_VERIFICATION_ERROR(HttpStatus.BAD_REQUEST,"로그인 토큰을 재발행 해주세요."),

    // 로그인
    LOGIN_CHECK_FAIL(HttpStatus.BAD_REQUEST,"로그인에 실패 하였습니다."),

    // 계좌
    FULL_ACCOUNT_HAVING(HttpStatus.BAD_REQUEST,"가질수 있는 계좌 3개를 초과 하였습니다."),
    ALREADY_ACCOUNT_NUMBER(HttpStatus.BAD_REQUEST,"이미 계좌번호가 존재합니다."),
    WRONG_AMOUNT_MONEY(HttpStatus.BAD_REQUEST,"입금 금액에는 숫자만 입력해주세요."),
    MINUS_BALANCE_MONEY(HttpStatus.BAD_REQUEST,"잔액 부족"),
    NOT_HAVING_ACCOUNT_NUMBER(HttpStatus.BAD_REQUEST,"계좌번호가 존재하지 않습니다."),

    //송금
    NULL_DATA_TRANSFER(HttpStatus.BAD_REQUEST,"송금 내역이 없습니다.");


    private final HttpStatus httpStatus;
    private final String detail;
}
