package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Ciudad;
import com.example.demo.repositories.CiudadRepository;
import com.example.demo.services.CiudadService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadServiceImpl implements CiudadService {

	private final CiudadRepository ciudadRepository;

	@Override
	public List<Ciudad> getAllCiudades() {
		
		return this.ciudadRepository.findAll();
	}

	@Override
	public Optional<Ciudad> getCiudadById(Long id) {
		return this.ciudadRepository.findById(id);
	}

	@Override
	public void saveCiudades(Ciudad rol) {
		if (Objects.nonNull(rol)) {
			this.ciudadRepository.save(rol);
		}
	}

	@Override
	public void deleteCiudad(Long id) {
		if(Objects.nonNull(id)) {
			this.ciudadRepository.findById(id).ifPresent(rol -> this.ciudadRepository.delete(rol));
		}
	}

}
