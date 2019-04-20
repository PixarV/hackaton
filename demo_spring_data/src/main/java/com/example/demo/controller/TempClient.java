package com.example.demo.controller;

import com.example.demo.model.Temp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("demospringdata")
public interface TempClient {

    @GetMapping(value = "/temp/{id}")
    Temp get(@PathVariable("id") int id);
}
