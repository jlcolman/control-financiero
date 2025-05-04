package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Mercaderia;
import com.example.demo.repositories.MercaderiaRepository;
import com.example.demo.services.MercaderiaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MercaderiaServiceImpl implements MercaderiaService {

    private final MercaderiaRepository repository;

    @Override
    public List<Mercaderia> getAllMercaderias() {
        return repository.findAllMercaderias();
    }

    @Override
    public Optional<Mercaderia> getMercaderiaById(Long idMercaderia) {
        return repository.findById(idMercaderia);
    }

    @Override
    public void saveMercaderia(Mercaderia mercaderia) {
        this.repository.save(mercaderia);
    }

    @Override
    public void deleteMercaderia(Long idMercaderia) {
        if (Objects.nonNull(idMercaderia)) {
            this.repository.findById(idMercaderia).ifPresent(this.repository::delete);
        }
    }
}