package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Banco;

public interface BancoService {

    List<Banco> getAlls();

    Optional<Banco> getById(Long id);

    void save(Banco banco);

    void delete(Long id);
}
