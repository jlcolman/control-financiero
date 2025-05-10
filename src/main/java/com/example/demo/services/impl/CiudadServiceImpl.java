package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Ciudad;
import com.example.demo.repositories.CiudadRepository;
import com.example.demo.services.CiudadService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository repository;

    @Override
    public List<Ciudad> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Ciudad> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Ciudad ciudad) {
        this.repository.save(ciudad);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(ciudad -> this.repository.delete(ciudad));
        }
    }
}
