package com.example.demo.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ajustes")
@Data
public class Ajustes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ajuste")
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sucursal")
	private Sucursales sucursal;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_ajuste")
	private List<AjustesDetalle> detalles;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;
	
    private Date fecha;
    
    private String observacion;
    
    private String tipo;
    
    private String estado;
    
    public void eliminarRelacionDetalle(AjustesDetalle detalle) {
    	this.detalles.remove(detalle);
    }
    
    public void agregarDetalles(List<AjustesDetalle> detalles) {
    	
    	if (Objects.isNull(detalles) || detalles.isEmpty()) {
    		throw new IllegalArgumentException("No se puede procesar el listado sin datos");
    	}
    	
    	detalles.stream().forEach(detalle -> procesarDetalle(detalle));
   
    }
    
    public void procesarDetalle(AjustesDetalle detalle) {
    	
    	if (Objects.isNull(detalle)) {
    		throw new IllegalArgumentException("No se puede procesar el listado sin datos"); 		
    	}
    	
    	if (Objects.isNull(this.detalles)) {
    		this.detalles = new ArrayList<>();
    	}
    	
    	this.detalles.add(detalle);
    	
    }
}