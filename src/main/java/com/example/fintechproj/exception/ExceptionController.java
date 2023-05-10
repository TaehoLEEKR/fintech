package com.example.fintechproj.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({
            UserException.class
    })
    public ResponseEntity<ExceptionResponse> UserRequestException(final UserException u){
        return ResponseEntity.badRequest().body(new ExceptionResponse(u.getMessage() , u.getErrorCode()));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class ExceptionResponse{
        private String message;
        private ErrorCode errorCode;
    }
}
