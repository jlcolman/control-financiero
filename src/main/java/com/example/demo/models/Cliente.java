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
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
<<<<<<< HEAD
    private Long idCliente;
=======
    private Integer idCliente;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_barrio")
    private Barrios barrios;

    @NotNull
    @Size(max = 100)
    @Column(name = "razon_social")
    private String razonSocial;

    @NotNull
    @Size(max = 20)
    @Column(name = "ruc")
    private String ruc;

    @NotNull
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;

    @NotNull
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;

    @NotNull
    @Email
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @Size(max = 3)
    @Column(name = "tipo_cliente")
    private String tipoCliente;
}
