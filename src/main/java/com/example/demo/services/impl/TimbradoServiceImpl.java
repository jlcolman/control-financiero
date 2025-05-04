package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Timbrado;
import com.example.demo.repositories.TimbradoRepository;
import com.example.demo.services.TimbradoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TimbradoServiceImpl implements TimbradoService {

    private final TimbradoRepository repository;

    @Override
    public List<Timbrado> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Timbrado> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Timbrado timbrado) {
        this.repository.save(timbrado);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(timbrado -> this.repository.delete(timbrado));
        }
    }
}
