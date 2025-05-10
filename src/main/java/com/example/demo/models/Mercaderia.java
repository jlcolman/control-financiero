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

import java.math.BigDecimal;

@Entity
@Table(name = "mercaderias")
@Data
public class Mercaderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercaderia")
    private Long idMercaderia;

    @NotNull
    @Column(name = "id_marca")
<<<<<<< HEAD
    private Long idMarca;

    @NotNull
    @Column(name = "id_tipo_impuesto")
    private Long idTipoImpuesto;

    @Column(name = "id_procedencia")
    private Long idProcedencia;
=======
    private Integer idMarca;

    @NotNull
    @Column(name = "id_tipo_impuesto")
    private Integer idTipoImpuesto;

    @Column(name = "id_procedencia")
    private Integer idProcedencia;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @NotNull
    @Size(max = 100)
    private String descripcion;

    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "afecta_existencia")
    private String afectaExistencia;

    @NotNull
    @Column(name = "precio_compra", precision = 12)
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "precio_venta", precision = 12)
    private BigDecimal precioVenta;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", insertable = false, updatable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_tipo_impuesto", referencedColumnName = "id_tipo_impuesto", insertable = false, updatable = false)
    private TipoImpuesto tipodeImpuesto;

   
}
