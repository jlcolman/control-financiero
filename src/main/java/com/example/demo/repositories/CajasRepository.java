package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cajas;

@Repository
public interface CajasRepository extends CrudRepository<Cajas, Long> {

    @Query("SELECT c from Cajas c")
    List<Cajas> findByAll();
}
