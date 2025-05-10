package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cajas;
import com.example.demo.repositories.CajasRepository;
import com.example.demo.services.CajasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CajasServiceImpl implements CajasService {

    private final CajasRepository repository;

    @Override
    public List<Cajas> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Cajas> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Cajas caja) {
        this.repository.save(caja);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(caja -> this.repository.delete(caja));
        }
    }
}
