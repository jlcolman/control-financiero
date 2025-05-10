package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Departamento;

public interface DepartamentoService {

	List<Departamento> getAllDepartamentos();

	Optional<Departamento> getDepartamentoById(Long idDepartamento);

	void saveDepartamento(Departamento departamento);

	void deleteDepartamento(Long id);
}
