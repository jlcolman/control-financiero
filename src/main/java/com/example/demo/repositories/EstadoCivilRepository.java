package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.EstadoCivil;

@Repository
public interface EstadoCivilRepository extends CrudRepository<EstadoCivil, Long> {

    @Query("SELECT ec FROM EstadoCivil ec")
    List<EstadoCivil> findAllEstadoCivil();
}