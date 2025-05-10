package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Cajas;

public interface CajasService {

    List<Cajas> getAlls();

<<<<<<< HEAD
    Optional<Cajas> getById(Long idCaja);
=======
    Optional<Cajas> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(Cajas caja);

    void delete(Long id);
}
