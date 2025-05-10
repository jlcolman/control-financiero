package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Empleado;
import com.example.demo.repositories.EmpleadoRepository;
import com.example.demo.services.EmpleadoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository repository;

    @Override
    public List<Empleado> getAllEmpleados() {
        return repository.findAll();
    }

    @Override
    public Optional<Empleado> getEmpleadoById(Long idEmpleado) {
        return repository.findById(idEmpleado);
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        this.repository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Long idEmpleado) {
        if (Objects.nonNull(idEmpleado)) {
            this.repository.findById(idEmpleado).ifPresent(empleado -> this.repository.delete(empleado));
        }
    }
}