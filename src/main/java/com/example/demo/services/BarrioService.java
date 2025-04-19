package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Barrio;

public interface BarrioService {

    List<Barrio> getAllBarrios();

    Optional<Barrio> getBarrioById(Long id);

    void saveBarrio(Barrio barrio);

    void deleteBarrio(Long id);
}