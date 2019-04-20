package com.example.demo.controller;

import com.example.demo.model.Temp;
import com.example.demo.service.TempService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/temp")
public class TempController {

    private TempService tempService;

    @GetMapping(value = "/{id}")
    public Temp get(@PathVariable("id") int id) {
        System.out.println("in rest-controller");
        return tempService.get(id);
    }
}
