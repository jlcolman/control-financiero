package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Ajustes;


@Repository
public interface AjustesRespository extends CrudRepository<Ajustes, Long> {

    @Query("SELECT u from Ajustes u")
    List<Ajustes> findByAll();
<<<<<<< HEAD
}
=======
}
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
