package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Barrios;

public interface BarriosService {

    List<Barrios> getAlls();

    Optional<Barrios> getById(Long id);

    void save(Barrios barrio);

    void delete(Long id);
}