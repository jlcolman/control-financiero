package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Barrio;
import com.example.demo.repositories.BarrioRepository;
import com.example.demo.services.BarrioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BarrioServiceImpl implements BarrioService {

    private final BarrioRepository barrioRepository;

    @Override
    public List<Barrio> getAllBarrios() {
        return this.barrioRepository.findAll();
    }

    @Override
    public Optional<Barrio> getBarrioById(Long id) {
        return this.barrioRepository.findById(id);
    }

    @Override
    public void saveBarrio(Barrio barrio) {
        if (Objects.nonNull(barrio)) {
            this.barrioRepository.save(barrio);
        }
    }

    @Override
    public void deleteBarrio(Long id) {
        if (Objects.nonNull(id)) {
            this.barrioRepository.findById(id).ifPresent(barrio -> this.barrioRepository.delete(barrio));
        }
    }
}