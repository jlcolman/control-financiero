package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "marcas", uniqueConstraints = { @UniqueConstraint(columnNames = { "descripcion" }) })
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
<<<<<<< HEAD
    private Long idMarca;
=======
    private Integer idMarca;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @NotNull
    @Size(max = 80)
    private String descripcion;
}