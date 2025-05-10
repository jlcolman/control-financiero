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
@Table(name = "bancos")
@Data
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
<<<<<<< HEAD
    private Long idBanco;
=======
    private Integer idBanco;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;

    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
}
