package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Barrios;

public interface BarriosService {

    List<Barrios> getAlls();

<<<<<<< HEAD
    Optional<Barrios> getById(Long idBarrios);
=======
    Optional<Barrios> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(Barrios barrio);

    void delete(Long id);
}