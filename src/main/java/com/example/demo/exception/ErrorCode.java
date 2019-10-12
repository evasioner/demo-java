package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    BAD_REQUEST(-400, "error.100.BAD_REQUEST", HttpStatus.BAD_REQUEST),
    INVALID_PARAMETER(-401, "error.100.INVALID_PARAMETER", HttpStatus.BAD_REQUEST),
    VERIFY_TOKEN_EXPIRED(-402, "error.100.VERIFY_TOKEN_EXPIRED", HttpStatus.BAD_REQUEST),
    UNDISCONNECTABLE(-403, "error.100.UNDISCONNECTABLE", HttpStatus.BAD_REQUEST),

    // 보안 인증
//    UNAUTHORIZED(-401000, "error.100.UNAUTHORIZED", HttpStatus.UNAUTHORIZED),
//    CANNOT_FOUND_USER(-401001, "error.100.CANNOT_FOUND_USER", HttpStatus.UNAUTHORIZED),
//    CANNOT_FOUND_MFA(-401002, "error.100.CANNOT_FOUND_MFA", HttpStatus.UNAUTHORIZED),
//    NOT_MATCHED_SECURE_CODE(-401101, "error.100.NOT_MATCHED_SECURE_CODE", HttpStatus.UNAUTHORIZED),
//    NOT_MATCHED_EMAIL_KEY(-401102, "error.100.NOT_MATCHED_EMAIL_KEY", HttpStatus.UNAUTHORIZED),
//    NOT_MATCHED_SECURE_KEY(-401103, "error.100.NOT_MATCHED_SECURE_KEY", HttpStatus.UNAUTHORIZED),
//
//    UN_VERIFIED_EMAIL(-401200, "error.100.UN_VERIFIED_EMAIL", HttpStatus.UNAUTHORIZED),
//    EXCEED_VERIFICATION(-401201, "error.100.EXCEED_VERIFICATION", HttpStatus.UNAUTHORIZED),

    UNKNOWN(-999, "error.100.UNKNOWN", HttpStatus.INTERNAL_SERVER_ERROR),
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
