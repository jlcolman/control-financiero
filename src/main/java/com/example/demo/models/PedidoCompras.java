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
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "pedido_compras")
@Data
public class PedidoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_compra")
    private Integer idPedidoCompra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Size(max = 1)
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;
}
