package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Ajustes;
import com.example.demo.models.AjustesDetallePK;
import com.example.demo.repositories.AjustesDetalleRespository;
import com.example.demo.repositories.AjustesRespository;
import com.example.demo.services.AjustesService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AjustesServicelmpl implements AjustesService {
	
	private final AjustesRespository ajustesRespository;
	private final AjustesDetalleRespository detalleRespository;
	
	@Override
    public List<Ajustes> getAll () {
		return ajustesRespository.findByAll();
	}
	
	@Override
    public Optional<Ajustes> getById (Long id) {
		return this.ajustesRespository.findById(id);
	}
	
	@Override
    public void save(Ajustes ajuste) {
		this.ajustesRespository.save(ajuste);
	}
	@Override
    public void delete(Long id) {
		if (Objects.nonNull(id)) {
		this.ajustesRespository.findById(id).ifPresent(ajuste -> this.ajustesRespository.delete(ajuste));
		}
	}
    
	@Override
	public void deleteDetails(Long idAjuste, Long idMercancia) {
		if (Objects.nonNull(idAjuste) && Objects.nonNull(idMercancia)) {
			AjustesDetallePK id = new AjustesDetallePK();
			id.setAjusteId(idAjuste);
			id.setMercaderiaId(idMercancia);
		
			this.detalleRespository.deleteById(id);
			
		}
		
	}

	
}