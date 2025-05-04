package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AjustesDetallePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_ajuste", nullable = false)
	private Long ajusteId;
	
	@Column(name = "id_mercaderia")
	private Long mercaderiaId;
	
	@Override
	public String toString() {
			return "{\"ajusteId\": \"" + ajusteId + "\"" + ", \"mercaderiaId\" : \"" + mercaderiaId + "\"}";
	}
	
}
