package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @NotNull
    @Size(max = 15)
    private String legajo;

    @NotNull
    @Column(name = "id_barrio")
<<<<<<< HEAD
    private Long idBarrio;

    @NotNull
    @Column(name = "id_nacionalidad")
    private Long idNacionalidad;

    @NotNull
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotNull
    @Column(name = "id_estado_civil")
    private Long idEstadoCivil;
=======
    private Integer idBarrio;

    @NotNull
    @Column(name = "id_nacionalidad")
    private Integer idNacionalidad;

    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotNull
    @Column(name = "id_estado_civil")
    private Integer idEstadoCivil;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @NotNull
    @Size(max = 50)
    private String nombres;

    @NotNull
    @Size(max = 50)
    private String apellidos;

    @NotNull
    @Size(max = 20)
    @Column(name = "cedula_identidad")
    private String cedulaIdentidad;

    @NotNull
    @Column(name = "fecha_nac")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNac;

    @Size(max = 1)
    private String sexo;

    @Size(max = 1)
    private String estado;

    @Column(name = "fecha_incorporacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIncorporacion;

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

}