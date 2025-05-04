package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TipoImpuesto;

@Repository
public interface TipoImpuestoRepository extends CrudRepository<TipoImpuesto, Long> {

    @Query("SELECT ti FROM TipoImpuesto ti")
    List<TipoImpuesto> findAllTiposImpuesto();

}