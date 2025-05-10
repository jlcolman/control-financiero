package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.PresupuestoCompras;
import com.example.demo.repositories.PresupuestoComprasRepository;
import com.example.demo.services.PresupuestoComprasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PresupuestoComprasServiceImpl implements PresupuestoComprasService {

    private final PresupuestoComprasRepository repository;

    @Override
    public List<PresupuestoCompras> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<PresupuestoCompras> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(PresupuestoCompras presupuestoCompra) {
        this.repository.save(presupuestoCompra);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(presupuestoCompra -> this.repository.delete(presupuestoCompra));
        }
    }
}
