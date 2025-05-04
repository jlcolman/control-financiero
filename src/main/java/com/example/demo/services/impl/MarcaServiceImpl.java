package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Marca;
import com.example.demo.repositories.MarcaRepository;
import com.example.demo.services.MarcaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository repository;

    @Override
    public List<Marca> getAllMarcas() {
        return repository.findAllMarcas();
    }

    @Override
    public Optional<Marca> getMarcaById(Long idMarca) {
        return repository.findById(idMarca);
    }

    @Override
    public void saveMarca(Marca marca) {
        this.repository.save(marca);
    }

    @Override
    public void deleteMarca(Long idMarca) {
        if (Objects.nonNull(idMarca)) {
            this.repository.findById(idMarca).ifPresent(this.repository::delete);
        }
    }
}
