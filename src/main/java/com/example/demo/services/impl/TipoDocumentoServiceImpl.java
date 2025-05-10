package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.TipoDocumentos;
import com.example.demo.repositories.TipoDocumentoRepository;
import com.example.demo.services.TipoDocumentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoRepository repository;

    @Override
    public List<TipoDocumentos> getAlls() {
        return repository.findByAll();
    }

    @Override
<<<<<<< HEAD
    public Optional<TipoDocumentos> getById(Long idTipoDocumento) {
        return repository.findById(idTipoDocumento);
=======
    public Optional<TipoDocumentos> getById(Long id) {
        return repository.findById(id);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
    }

    @Override
    public void save(TipoDocumentos tipoDocumento) {
        this.repository.save(tipoDocumento);
    }

    @Override
<<<<<<< HEAD
    public void delete(Long idTipoDocumento) {
        if (Objects.nonNull(idTipoDocumento)) {
            this.repository.findById(idTipoDocumento).ifPresent(tipoDocumento -> this.repository.delete(tipoDocumento));
=======
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(tipoDocumento -> this.repository.delete(tipoDocumento));
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
        }
    }
}