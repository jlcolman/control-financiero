package com.example.demo.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table (name = "ajustes_detalle")
@Data
public class AjustesDetalle {

	@EmbeddedId
	private AjustesDetallePK id;
	
	@Column(name = "precio_compra")
	private BigDecimal precio;
	
	private Integer cantidad;
}
