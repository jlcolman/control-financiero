package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.EstadoCivil;
import com.example.demo.repositories.EstadoCivilRepository;
import com.example.demo.services.EstadoCivilService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstadoCivilServiceImpl implements EstadoCivilService {

    private final EstadoCivilRepository repository;

    @Override
    public List<EstadoCivil> getAllEstadoCivil() {
        return repository.findAllEstadoCivil();
    }

    @Override
    public Optional<EstadoCivil> getEstadoCivilById(Long idEstadoCivil) {
        return repository.findById(idEstadoCivil);
    }

    @Override
    public void saveEstadoCivil(EstadoCivil estadoCivil) {
        this.repository.save(estadoCivil);
    }

    @Override
    public void deleteEstadoCivil(Long idEstadoCivil) {
        if (Objects.nonNull(idEstadoCivil)) {
            this.repository.findById(idEstadoCivil).ifPresent(this.repository::delete);
        }
    }
}
