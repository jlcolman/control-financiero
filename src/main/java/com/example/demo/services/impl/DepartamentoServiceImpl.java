package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Departamento;
import com.example.demo.repositories.DepartamentoRepository;
import com.example.demo.services.DepartamentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

	private final DepartamentoRepository departamentoRepository;

	@Override
	public List<Departamento> getAllDepartamentos() {
		return this.departamentoRepository.findAllDepartamentos();
	}

	@Override
	public Optional<Departamento> getDepartamentoById(Long id) {
		return this.departamentoRepository.findById(id);
	}

	@Override
	public void saveDepartamento(Departamento departamento) {
		if (Objects.nonNull(departamento)) {
			this.departamentoRepository.save(departamento);
		}
	}

	@Override
	public void deleteDepartamento(Long id) {
		if(Objects.nonNull(id)) {
			this.departamentoRepository.findById(id).ifPresent(departamento -> this.departamentoRepository.delete(departamento));
		}
	}

}
