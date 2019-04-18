package com.epam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {
    @GetMapping("/secret")
    public String cobolKruto(){
        return "Come to the DevOps side, we have Docker";
    }

}
