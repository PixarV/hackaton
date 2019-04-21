package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    @Autowired
    TempClient client;

    @GetMapping(value = "/{id}")
    public String hello(@PathVariable("id") int id) {
//        return "hello";
        return client.get(2);
    }

    @RequestMapping("/probe")
    public String index1() {
        return "hello";
//        return client.get(2).toString();
    }
}
