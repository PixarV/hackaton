package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("hello")
public interface HelloClient {

    @GetMapping("/hello")
    String getHello();
}
