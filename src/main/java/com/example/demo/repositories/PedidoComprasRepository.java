package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PedidoCompras;

@Repository
public interface PedidoComprasRepository extends CrudRepository<PedidoCompras, Long> {

    @Query("SELECT pc from PedidoCompras pc")
    List<PedidoCompras> findByAll();
}
