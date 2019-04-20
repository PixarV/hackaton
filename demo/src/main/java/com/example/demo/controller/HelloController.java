package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    TempClient client;

    @RequestMapping("/hello")
    public String index() {
        //return "hello";
        return client.get(2).toString();
    }
}
