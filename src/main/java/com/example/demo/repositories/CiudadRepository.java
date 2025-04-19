package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

	@Query("SELECT s from Ciudad s")
	List<Ciudad> findAll();
}
