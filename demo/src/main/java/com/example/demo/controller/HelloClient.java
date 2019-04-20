package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello")
public interface HelloClient {

    @GetMapping("/hello")
    String greetings();

    @RequestMapping("/hello/{id}")
    String greetingsFor(@PathVariable("id") int id);
}
