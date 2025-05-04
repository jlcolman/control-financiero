package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.OrdenCompras;

public interface OrdenComprasService {

    List<OrdenCompras> getAlls();

    Optional<OrdenCompras> getById(Long id);

    void save(OrdenCompras ordenCompra);

    void delete(Long id);
}
