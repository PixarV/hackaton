package com.example.demo.service.impl;

import com.example.demo.model.Temp;
import com.example.demo.repository.CrudTempRepository;
import com.example.demo.service.TempService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TempServiceImpl implements TempService {

    @Autowired
    private CrudTempRepository repository;

    @Override
    public Temp get(int id) {
        return repository.findById(id).orElse(null);
    }
}
