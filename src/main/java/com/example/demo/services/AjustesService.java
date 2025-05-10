package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import com.example.demo.models.Ajustes;


public interface AjustesService {

    List<Ajustes> getAll();

    Optional<Ajustes> getById(Long id);

    void save(Ajustes ajuste);
    
    void delete(Long id);

    void deleteDetails(Long idAjuste, Long idMercancia);

}