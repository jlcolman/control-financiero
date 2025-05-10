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
@Table(name = "cajas")
@Data
public class Cajas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja")
<<<<<<< HEAD
    private Long idCaja;
=======
    private Integer idCaja;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
}