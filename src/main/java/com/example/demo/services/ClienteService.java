package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Cliente;

public interface ClienteService {

    List<Cliente> getAlls();

<<<<<<< HEAD
    Optional<Cliente> getById(Long idCliente);
=======
    Optional<Cliente> getById(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void save(Cliente cliente);

    void delete(Long id);
}
