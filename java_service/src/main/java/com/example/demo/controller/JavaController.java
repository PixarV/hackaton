package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaController {
    @GetMapping("/java")
    public String cobolKruto(){
        return "COBOL - круто!";
    }

}
