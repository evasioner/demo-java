package com.example.demo.controllers;

import com.example.demo.response.Response;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public abstract class BaseController {
    protected static final Response<Boolean> SUCCESS = Response.succ(Boolean.TRUE);
    protected static final Response<Boolean> FAIL = Response.succ(Boolean.FALSE);

    protected <T> Response<T> response(T data) {
        return Response.succ(data);
    }
}
