package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Nacionalidad;

@Repository
public interface NacionalidadRepository extends CrudRepository<Nacionalidad, Long> {

    @Query("SELECT n FROM Nacionalidad n")
    List<Nacionalidad> findAllNacionalidades();

}