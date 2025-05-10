package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PresupuestoCompras;

public interface PresupuestoComprasService {

    List<PresupuestoCompras> getAlls();

<<<<<<< HEAD
    Optional<PresupuestoCompras> getById(Long idPresupuestoCompra);
=======
    Optional<PresupuestoCompras> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(PresupuestoCompras presupuestoCompra);

    void delete(Long id);
}
