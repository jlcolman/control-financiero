package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Mercaderia;

@Repository
public interface MercaderiaRepository extends CrudRepository<Mercaderia, Long> {

    @Query("SELECT m FROM Mercaderia m")
    List<Mercaderia> findAllMercaderias();

}