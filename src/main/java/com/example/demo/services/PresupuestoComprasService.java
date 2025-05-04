package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PresupuestoCompras;

public interface PresupuestoComprasService {

    List<PresupuestoCompras> getAlls();

    Optional<PresupuestoCompras> getById(Long id);

    void save(PresupuestoCompras presupuestoCompra);

    void delete(Long id);
}
