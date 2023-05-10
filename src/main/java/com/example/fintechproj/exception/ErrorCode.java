package com.example.fintechproj.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    NOT_FOUND_EMAIL(HttpStatus.BAD_REQUEST,"이메일이 존재 하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
