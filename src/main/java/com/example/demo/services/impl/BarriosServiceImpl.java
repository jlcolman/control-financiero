package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Barrios;
import com.example.demo.repositories.BarriosRepository;
import com.example.demo.services.BarriosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BarriosServiceImpl implements BarriosService {

    private final BarriosRepository repository;

    @Override
    public List<Barrios> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Barrios> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Barrios barrio) {
        this.repository.save(barrio);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(barrio -> this.repository.delete(barrio));
        }
    }
}