package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Barrio;

@Repository
public interface BarrioRepository extends CrudRepository<Barrio, Long> {

    @Query("SELECT b from Barrio b")
    List<Barrio> findAll();
}