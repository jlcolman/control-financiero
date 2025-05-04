package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Empleado;

public interface EmpleadoService {

    List<Empleado> getAllEmpleados();

    Optional<Empleado> getEmpleadoById(Long idEmpleado);

    void saveEmpleado(Empleado empleado);

    void deleteEmpleado(Long idEmpleado);

	Object findAll();
}