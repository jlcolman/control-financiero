package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.OrdenCompras;
import com.example.demo.repositories.OrdenComprasRepository;
import com.example.demo.services.OrdenComprasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrdenComprasServiceImpl implements OrdenComprasService {

    private final OrdenComprasRepository repository;

    @Override
    public List<OrdenCompras> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<OrdenCompras> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(OrdenCompras ordenCompra) {
        this.repository.save(ordenCompra);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(ordenCompra -> this.repository.delete(ordenCompra));
        }
    }
}