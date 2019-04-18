package com.epam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CobolController {
    @GetMapping("/cobol")
    public String cobolKruto(){
        return "Эй, Java, говори: COBOL - круто!";
    }

}
