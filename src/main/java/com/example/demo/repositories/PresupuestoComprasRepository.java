package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PresupuestoCompras;

@Repository
public interface PresupuestoComprasRepository extends CrudRepository<PresupuestoCompras, Long> {

    @Query("SELECT pc from PresupuestoCompras pc")
    List<PresupuestoCompras> findByAll();
}