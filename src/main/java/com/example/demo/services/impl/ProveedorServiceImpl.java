package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Proveedor;
import com.example.demo.repositories.ProveedorRepository;
import com.example.demo.services.ProveedorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repository;

    @Override
    public List<Proveedor> getAllProveedores() {
        return repository.findAllProveedores();
    }

    @Override
    public Optional<Proveedor> getProveedorById(Long idProveedor) {
        return repository.findById(idProveedor);
    }

    @Override
    public void saveProveedor(Proveedor proveedor) {
        this.repository.save(proveedor);
    }

    @Override
    public void deleteProveedor(Long idProveedor) {
        if (Objects.nonNull(idProveedor)) {
            this.repository.findById(idProveedor).ifPresent(this.repository::delete);
        }
    }
}
