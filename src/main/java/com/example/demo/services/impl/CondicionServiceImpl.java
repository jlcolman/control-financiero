package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Condicion;
import com.example.demo.repositories.CondicionRepository;
import com.example.demo.services.CondicionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CondicionServiceImpl implements CondicionService {

    private final CondicionRepository repository;

    @Override
    public List<Condicion> getAlls() {
        return repository.findByAll();
    }

    @Override
<<<<<<< HEAD
    public Optional<Condicion> getById(Long idCondicion) {
        return repository.findById(idCondicion);
=======
    public Optional<Condicion> getById(Long id) {
        return repository.findById(id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @Override
    public void save(Condicion condicion) {
        this.repository.save(condicion);
    }

    @Override
<<<<<<< HEAD
    public void delete(Long idCondicion) {
        if (Objects.nonNull(idCondicion)) {
            this.repository.findById(idCondicion).ifPresent(condicion -> this.repository.delete(condicion));
=======
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(condicion -> this.repository.delete(condicion));
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
        }
    }
}
