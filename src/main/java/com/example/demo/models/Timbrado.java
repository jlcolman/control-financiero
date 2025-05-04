package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "timbrados")
@Data
public class Timbrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timbrado")
    private Integer idTimbrado;

    @NotNull
    @Column(name = "nro_desde")
    private Integer nroDesde;

    @NotNull
    @Column(name = "nro_hasta")
    private Integer nroHasta;

    @NotNull
    @Column(name = "nro3")
    private Integer nro3;

    @NotNull
    @Column(name = "nro_timbrado")
    private Integer nroTimbrado;

    @NotNull
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentos tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "nro1")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "nro2")
    private Cajas caja;

    @Column(name = "estado", length = 3)
    private String estado;
}