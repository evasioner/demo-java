package com.example.demo.controllers;

import com.example.demo.response.Response;
import com.example.demo.utils.JwtToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mit ")
@Api(tags = {"2. Token"})
@RestController
public class TokenController extends BaseController {

    @ApiOperation(value = "JWT Token", notes = "JWT Token 요청")
    @GetMapping("")
    public Response<String> getToken() {
        return response(JwtToken.getJWTToken());
    }
}
