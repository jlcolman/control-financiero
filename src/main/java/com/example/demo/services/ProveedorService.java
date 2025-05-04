package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Proveedor;

public interface ProveedorService {

    List<Proveedor> getAllProveedores();

    Optional<Proveedor> getProveedorById(Long idProveedor);

    void saveProveedor(Proveedor proveedor);

    void deleteProveedor(Long idProveedor);
}
