package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @NotNull
    @Column(name = "id_barrio")
    private Integer idBarrio;

    @NotNull
    @Size(max = 100)
    @Column(name = "razon_social")
    private String razonSocial;

    @NotNull
    @Size(max = 20)
    private String ruc;

    @NotNull
    @Size(max = 100)
    private String direccion;

    @NotNull
    @Size(max = 20)
    private String telefono;

    @NotNull
    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 3)
    @Column(name = "tipo_persona")
    private String tipoPersona;

    @ManyToOne
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio", insertable = false, updatable = false)
    private Barrios barrios;
}
