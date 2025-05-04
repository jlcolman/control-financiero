package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.OrdenCompras;

@Repository
public interface OrdenComprasRepository extends CrudRepository<OrdenCompras, Long> {

    @Query("SELECT oc from OrdenCompras oc")
    List<OrdenCompras> findByAll();
}