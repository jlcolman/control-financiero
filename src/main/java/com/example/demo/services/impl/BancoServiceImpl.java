package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Banco;
import com.example.demo.repositories.BancoRepository;
import com.example.demo.services.BancoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BancoServiceImpl implements BancoService {

    private final BancoRepository repository;

    @Override
    public List<Banco> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<Banco> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Banco banco) {
        this.repository.save(banco);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(banco -> this.repository.delete(banco));
        }
    }
}