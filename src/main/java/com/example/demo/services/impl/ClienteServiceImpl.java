package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.ClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<Cliente> getAlls() {
        return repository.findByAll();
    }

    @Override
<<<<<<< HEAD
    public Optional<Cliente> getById(Long idCliente) {
        return repository.findById(idCliente);
=======
    public Optional<Cliente> getById(Long id) {
        return repository.findById(id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @Override
    public void save(Cliente cliente) {
        this.repository.save(cliente);
    }

    @Override
<<<<<<< HEAD
    public void delete(Long idCliente) {
        if (Objects.nonNull(idCliente)) {
            this.repository.findById(idCliente).ifPresent(cliente -> this.repository.delete(cliente));
=======
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(cliente -> this.repository.delete(cliente));
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
        }
    }
}
