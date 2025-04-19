package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Paises; 
@Repository
public interface PaisesRepository extends CrudRepository<Paises, Long> {

    @Query("SELECT p from Paises p") 
    List<Paises> findAll(); 
}