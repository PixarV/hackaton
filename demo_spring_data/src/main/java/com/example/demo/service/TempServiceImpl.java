package com.example.demo.service;

import com.example.demo.model.Temp;
import com.example.demo.repository.CrudTempRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TempServiceImpl implements TempService {

    private final CrudTempRepository repository;

    @Override
    public Temp get(int id) {
        return repository.findById(id).orElse(null);
    }
}
