package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {

	@Query("SELECT d from Departamento d")
	List<Departamento> findAllDepartamentos();
}