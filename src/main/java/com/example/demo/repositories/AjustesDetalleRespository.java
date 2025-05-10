package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.AjustesDetalle;
import com.example.demo.models.AjustesDetallePK;


@Repository
public interface AjustesDetalleRespository extends CrudRepository<AjustesDetalle, AjustesDetallePK> {

    @Query("SELECT u from AjustesDetalle u")
    List<AjustesDetalle> findByAll();
}