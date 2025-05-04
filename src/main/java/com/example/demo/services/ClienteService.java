package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Cliente;

public interface ClienteService {

    List<Cliente> getAlls();

    Optional<Cliente> getById(Long id);

    void save(Cliente cliente);

    void delete(Long id);
}
