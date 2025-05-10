package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Proveedor;

public interface ProveedorService {

    List<Proveedor> getAllProveedores();

<<<<<<< HEAD
    Optional<Proveedor> getProveedorById(Long id);
=======
    Optional<Proveedor> getProveedorById(Long idProveedor);
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    void saveProveedor(Proveedor proveedor);

    void deleteProveedor(Long idProveedor);
}
