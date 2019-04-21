package com.example.demo.service.impl;

import com.example.demo.dto.TempDto;
import com.example.demo.model.Temp;
import com.example.demo.repository.CrudTempRepository;
import com.example.demo.service.TempService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TempServiceImpl implements TempService {

    @Autowired
    private CrudTempRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TempDto get(int id) {
        return convertToDto(repository.findById(id).orElse(null));
    }

    private TempDto convertToDto(Temp temp) {
        return modelMapper.map(temp, TempDto.class);
    }
}
