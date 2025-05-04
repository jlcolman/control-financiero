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
@Table(name = "barrios")
@Data
public class Barrios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barrio")
    private Integer idBarrio;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad idCiudad;

    @NotNull
    @Size(max = 80)
    @Column(name = "descripcion")
    private String descripcion;
}