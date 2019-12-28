package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication()
public class DemoApplication {

    private static ConfigurableApplicationContext configurableApplicationContext;

    public static ApplicationContext getApplicationContext() {
        return DemoApplication.configurableApplicationContext;
    }

    public static void main(String[] args) {
        configurableApplicationContext = SpringApplication.run(DemoApplication.class, args);
    }
}
