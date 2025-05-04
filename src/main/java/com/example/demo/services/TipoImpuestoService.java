package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TipoImpuesto;

public interface TipoImpuestoService {

    List<TipoImpuesto> getAllTiposImpuesto();

    Optional<TipoImpuesto> getTipoImpuestoById(Long idTipoImpuesto);

    void saveTipoImpuesto(TipoImpuesto tipoImpuesto);

    void deleteTipoImpuesto(Long idTipoImpuesto);
}
