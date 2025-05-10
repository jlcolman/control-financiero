package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Banco;

public interface BancoService {

    List<Banco> getAlls();

<<<<<<< HEAD
    Optional<Banco> getById(Long idBanco);
=======
    Optional<Banco> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(Banco banco);

    void delete(Long id);
}
