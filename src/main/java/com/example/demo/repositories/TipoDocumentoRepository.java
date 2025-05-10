package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TipoDocumentos;

@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumentos, Long> {

    @Query("SELECT td from TipoDocumentos td")
    List<TipoDocumentos> findByAll();
}