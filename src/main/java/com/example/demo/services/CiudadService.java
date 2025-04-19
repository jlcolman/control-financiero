package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Ciudad;

public interface CiudadService {

	List<Ciudad> getAllCiudades();

	Optional<Ciudad> getCiudadById(Long id);

	void saveCiudades(Ciudad rol);

	void deleteCiudad(Long id);
}
