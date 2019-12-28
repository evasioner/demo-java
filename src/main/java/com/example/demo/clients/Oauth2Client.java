package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign", url = "http://localhost:8080")
public interface Oauth2Client {
    @GetMapping("/auth")
    String auth();
}
