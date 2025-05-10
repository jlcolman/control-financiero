package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.EstadoCivil;

public interface EstadoCivilService {

    List<EstadoCivil> getAllEstadoCivil();

    Optional<EstadoCivil> getEstadoCivilById(Long idEstadoCivil);

    void saveEstadoCivil(EstadoCivil estadoCivil);

    void deleteEstadoCivil(Long idEstadoCivil);
}