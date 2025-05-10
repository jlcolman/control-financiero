package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PedidoCompras;

public interface PedidoComprasService {

    List<PedidoCompras> getAlls();

<<<<<<< HEAD
    Optional<PedidoCompras> getById(Long idPedidoCompra);
=======
    Optional<PedidoCompras> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(PedidoCompras pedidoCompra);

    void delete(Long id);
}
