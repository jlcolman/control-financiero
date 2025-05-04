package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TipoDocumentos;

public interface TipoDocumentoService {

    List<TipoDocumentos> getAlls();

    Optional<TipoDocumentos> getById(Long id);

    void save(TipoDocumentos tipoDocumento);

    void delete(Long id);
}