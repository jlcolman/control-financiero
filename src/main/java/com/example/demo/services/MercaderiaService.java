package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Mercaderia;

public interface MercaderiaService {

    List<Mercaderia> getAllMercaderias();

    Optional<Mercaderia> getMercaderiaById(Long idMercaderia);

    void saveMercaderia(Mercaderia mercaderia);

    void deleteMercaderia(Long idMercaderia);
}