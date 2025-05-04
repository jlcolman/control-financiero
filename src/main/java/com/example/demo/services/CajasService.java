package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Cajas;

public interface CajasService {

    List<Cajas> getAlls();

    Optional<Cajas> getById(Long id);

    void save(Cajas caja);

    void delete(Long id);
}
