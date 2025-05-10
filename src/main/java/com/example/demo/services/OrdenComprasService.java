package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.OrdenCompras;

public interface OrdenComprasService {

    List<OrdenCompras> getAlls();

<<<<<<< HEAD
    Optional<OrdenCompras> getById(Long idOrdenCompra);

    void save(OrdenCompras ordencompra);

    void delete(Long idOrdenCompra);
=======
    Optional<OrdenCompras> getById(Long id);

    void save(OrdenCompras ordenCompra);

    void delete(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
}
