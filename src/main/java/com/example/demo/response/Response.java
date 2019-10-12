package com.example.demo.response;

import com.example.demo.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Response<T> {
    private int status;
    private String result;
    private T data;
    private Error error;

    private Response(T data) {
        this.status = 200;
        this.result = "success";
        this.data = data;
    }

    private Response(int status, Error error) {
        this.status = status;
        this.result = "error";
        this.error = error;
    }

    public static <T> Response<T> succ(T result) {
        return new Response<>(result);
    }

    public static Response<Error> err(int status, Error error) {
        return new Response<>(status, error);
    }

    public static Response<Error> err(ErrorCode errorCode, Error error) {
        return err(errorCode.getStatus().value(), error);
    }
}
