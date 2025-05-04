package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Marca;

public interface MarcaService {

    List<Marca> getAllMarcas();

    Optional<Marca> getMarcaById(Long idMarca);

    void saveMarca(Marca marca);

    void deleteMarca(Long idMarca);
}