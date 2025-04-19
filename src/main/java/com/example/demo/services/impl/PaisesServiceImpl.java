package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Paises;
import com.example.demo.repositories.PaisesRepository;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaisesServiceImpl implements PaisesService {

    private final PaisesRepository paisesRepository;

    @Override
    public List<Paises> getAllPaises() {
        return this.paisesRepository.findAll();
    }

    @Override
    public Optional<Paises> getPaisById(Long id) {
        return this.paisesRepository.findById(id);
    }

    @Override
    public void savePais(Paises pais) {
        if (Objects.nonNull(pais)) {
            this.paisesRepository.save(pais);
        }
    }

    @Override
    public void deletePais(Long id) {
        if (Objects.nonNull(id)) {
            this.paisesRepository.findById(id).ifPresent(pais -> this.paisesRepository.delete(pais));
        }
    }
}
