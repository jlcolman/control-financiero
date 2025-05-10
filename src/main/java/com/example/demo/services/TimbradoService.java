package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Timbrado;

public interface TimbradoService {

    List<Timbrado> getAlls();

<<<<<<< HEAD
    Optional<Timbrado> getById(Long idTimbrado);
=======
    Optional<Timbrado> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(Timbrado timbrado);

    void delete(Long id);
}