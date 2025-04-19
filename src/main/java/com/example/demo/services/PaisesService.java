package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Paises; // Importa el modelo Pais

public interface PaisesService {

    List<Paises> getAllPaises(); 

    Optional<Paises> getPaisById(Long id); 

    void savePais(Paises paises);
    void deletePais(Long id); 
}