package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.TipoImpuesto;
import com.example.demo.repositories.TipoImpuestoRepository;
import com.example.demo.services.TipoImpuestoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoImpuestoServiceImpl implements TipoImpuestoService {

    private final TipoImpuestoRepository repository;

    @Override
    public List<TipoImpuesto> getAllTiposImpuesto() {
        return repository.findAllTiposImpuesto();
    }

    @Override
    public Optional<TipoImpuesto> getTipoImpuestoById(Long idTipoImpuesto) {
        return repository.findById(idTipoImpuesto);
    }

    @Override
    public void saveTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.repository.save(tipoImpuesto);
    }

    @Override
    public void deleteTipoImpuesto(Long idTipoImpuesto) {
        if (Objects.nonNull(idTipoImpuesto)) {
            this.repository.findById(idTipoImpuesto).ifPresent(this.repository::delete);
        }
    }
}