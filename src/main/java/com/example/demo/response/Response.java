package com.example.demo.response;

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
    private String error;

    public Response(T data) {
        this.status = 200;
        this.result = "success";
        this.data = data;
    }

    public Response(int status, String error) {
        this.status = status;
        this.result = "error";
        this.error = error;
    }

    public static <T> Response<T> succ(T result) {
        return new Response<>(result);
    }

    public static Response<Error> err(int status, String error) {
        return new Response<>(status, error);
    }
}
