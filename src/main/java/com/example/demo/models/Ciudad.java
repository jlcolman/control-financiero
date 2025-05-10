package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "ciudades")
@Data
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long idCiudad;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @NotNull
    @Size(max = 80)
    private String descripcion;
<<<<<<< HEAD
}
=======
}
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78
