package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Condicion;

@Repository
public interface CondicionRepository extends CrudRepository<Condicion, Long> {

    @Query("SELECT c from Condicion c")
    List<Condicion> findByAll();
}