package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TipoDocumentos;

public interface TipoDocumentoService {

    List<TipoDocumentos> getAlls();

<<<<<<< HEAD
    Optional<TipoDocumentos> getById(Long idTipoDocumento);

    void save(TipoDocumentos tipoDocumento);

    void delete(Long idTipoDocumento);
=======
    Optional<TipoDocumentos> getById(Long id);

    void save(TipoDocumentos tipoDocumento);

    void delete(Long id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
}