package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {

    @Query("SELECT p FROM Proveedor p")
    List<Proveedor> findAllProveedores();

   
}