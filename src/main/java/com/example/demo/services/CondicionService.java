package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Condicion;

public interface CondicionService {

    List<Condicion> getAlls();

<<<<<<< HEAD
    Optional<Condicion> getById(Long idCondicion);

    void save(Condicion condicion);

    void delete(Long idCondicion);
=======
    Optional<Condicion> getById(Long id);

    void save(Condicion condicion);

    void delete(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
}
