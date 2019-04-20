package com.example.demo.repository;

import com.example.demo.model.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudTempRepository extends JpaRepository<Temp, Integer> {
    @Override
    Optional<Temp> findById(Integer id);
}