package com.example.demo.clients;

import com.example.demo.dto.TempDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("demospringdata")
public interface TempClient {

    @GetMapping(value = "/temp/{id}")
    TempDto get(@PathVariable("id") int id);
}
