package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "condicion")
@Data
public class Condicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion")
<<<<<<< HEAD
    private Long idCondicion;
=======
    private Integer idCondicion;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cuota")
<<<<<<< HEAD
    private Long cuota;
=======
    private Integer cuota;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
}
