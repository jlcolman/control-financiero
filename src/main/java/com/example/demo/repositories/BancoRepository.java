package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Banco;

@Repository
public interface BancoRepository extends CrudRepository<Banco, Long> {

    @Query("SELECT b from Banco b")
    List<Banco> findByAll();
}
