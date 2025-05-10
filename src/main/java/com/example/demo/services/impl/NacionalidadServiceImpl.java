package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Nacionalidad;
import com.example.demo.repositories.NacionalidadRepository;
import com.example.demo.services.NacionalidadService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NacionalidadServiceImpl implements NacionalidadService {

    private final NacionalidadRepository repository;

    @Override
    public List<Nacionalidad> getAllNacionalidades() {
        return repository.findAllNacionalidades();
    }

    @Override
    public Optional<Nacionalidad> getNacionalidadById(Long idNacionalidad) {
        return repository.findById(idNacionalidad);
    }

    @Override
    public void saveNacionalidad(Nacionalidad nacionalidad) {
        this.repository.save(nacionalidad);
    }

    @Override
    public void deleteNacionalidad(Long idNacionalidad) {
        if (Objects.nonNull(idNacionalidad)) {
            this.repository.findById(idNacionalidad).ifPresent(this.repository::delete);
        }
    }
}
