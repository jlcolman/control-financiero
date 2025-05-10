package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("SELECT c from Cliente c")
    List<Cliente> findByAll();
}