package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Condicion;
import com.example.demo.repositories.CondicionRepository;
import com.example.demo.services.CondicionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CondicionServiceImpl implements CondicionService {

    private final CondicionRepository repository;

    @Override
    public List<Condicion> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Condicion> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Condicion condicion) {
        this.repository.save(condicion);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(condicion -> this.repository.delete(condicion));
        }
    }
}
