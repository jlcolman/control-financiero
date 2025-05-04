package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> {

    @Query("SELECT m FROM Marca m")
    List<Marca> findAllMarcas();

    
}