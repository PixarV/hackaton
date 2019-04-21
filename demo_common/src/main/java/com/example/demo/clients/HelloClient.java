package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hello")
public interface HelloClient {

    @GetMapping("/hello")
    String greetings();

    @GetMapping("/hello/{id}")
    String greetingsFor(@PathVariable("id") int id);
}
