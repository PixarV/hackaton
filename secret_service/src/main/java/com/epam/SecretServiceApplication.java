package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class SecretServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretServiceApplication.class, args);
    }
}