package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Ciudad;

public interface CiudadService {

    List<Ciudad> getAlls();

    Optional<Ciudad> getById(Long id);

    void save(Ciudad ciudad);

    void delete(Long id);
}