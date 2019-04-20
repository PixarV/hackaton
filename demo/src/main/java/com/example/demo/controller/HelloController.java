package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    TempClient client;

    @RequestMapping("/hello")
    public String greetings() {
        return "Hello!";
    }

    @RequestMapping("/hello/{id}")
    public String greetingsFor(@PathVariable("id") int id) {
        String greetings = "Hello, dear %s, welcome to the jungle!";
        try {
            return String.format(greetings, client.get(id).getName());
        } catch (Exception e) {
            return String.format(greetings, "NA");
        }
    }
}
