package com.example.demo.controller;

import com.example.demo.model.Temp;
import com.example.demo.service.TempService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private TempService tempService;

    @GetMapping(value = "/{id}")
    public String get(@PathVariable("id") int id) {
        System.out.println("in rest-controller with id" + id);
        return tempService.get(id).toString();
    }
}
