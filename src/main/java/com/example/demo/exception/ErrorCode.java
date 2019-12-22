package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    BAD_REQUEST(-400, "BAD_REQUEST", HttpStatus.BAD_REQUEST),
    INVALID_PARAMETER(-401, "INVALID_PARAMETER", HttpStatus.BAD_REQUEST),
    VERIFY_TOKEN_EXPIRED(-402, "VERIFY_TOKEN_EXPIRED", HttpStatus.BAD_REQUEST),
    UNDISCONNECTABLE(-403, "UNDISCONNECTABLE", HttpStatus.BAD_REQUEST),
    NOT_FOUND(-404, "NOT_FOND", HttpStatus.NOT_FOUND),

    // 인증
    UNAUTHORIZED(-401, "UNAUTHORIZED", HttpStatus.UNAUTHORIZED),
    UNKNOWN(-999, "UNKNOWN", HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    public static final int SERVICE_CODE = 100;

    private int code;
    private String message;
    private HttpStatus status;

    ErrorCode(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}