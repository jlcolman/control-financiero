package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Nacionalidad;

public interface NacionalidadService {

    List<Nacionalidad> getAllNacionalidades();

    Optional<Nacionalidad> getNacionalidadById(Long idNacionalidad);

    void saveNacionalidad(Nacionalidad nacionalidad);

    void deleteNacionalidad(Long idNacionalidad);
}