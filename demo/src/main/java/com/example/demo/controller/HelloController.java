package com.example.demo.controller;

import com.example.demo.clients.TempClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    private TempClient client;

    @GetMapping("/hello")
    public String greetings() {
        return "Hello!";
    }

    @GetMapping("/hello/{id}")
    public String greetingsFor(@PathVariable("id") int id) {
        String greetings = "Hello, dear %s, welcome to the jungle!";
        try {
            return String.format(greetings, client.get(id).getName());
        } catch (Exception e) {
            return String.format(greetings, "NA");
        }
    }
}
