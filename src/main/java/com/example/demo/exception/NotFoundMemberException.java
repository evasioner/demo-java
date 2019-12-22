package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cannot found member")
public class NotFoundMemberException extends BaseException {
    private static final String DEFAULT_MESSAGE = "Cannot found member";

    public NotFoundMemberException() {
        super(ErrorCode.NOT_FOUND, DEFAULT_MESSAGE);
    }
}
