package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    @Autowired
    TempClient client;

    @RequestMapping("/hello")
    public String index() {
//        return "hello";
        return client.get(2);
    }

    @RequestMapping("/probe")
    public String index1() {
        return "hello";
//        return client.get(2).toString();
    }
}
