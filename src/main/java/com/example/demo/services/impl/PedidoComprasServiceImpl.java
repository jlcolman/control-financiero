package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.PedidoCompras;
import com.example.demo.repositories.PedidoComprasRepository;
import com.example.demo.services.PedidoComprasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoComprasServiceImpl implements PedidoComprasService {

    private final PedidoComprasRepository repository;

    @Override
    public List<PedidoCompras> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<PedidoCompras> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(PedidoCompras pedidoCompra) {
        this.repository.save(pedidoCompra);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(pedidoCompra -> this.repository.delete(pedidoCompra));
        }
    }
}
