package com.vgs.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.vgs.gerenciador.entity.GastoEntity;
import com.vgs.gerenciador.DTO.GastoDTO;
import com.vgs.gerenciador.repository.GastoRepository;

@Service
public class GastoService {
	
	@Autowired
	private GastoRepository gastoRespository;
	
	//crud

	public List<GastoDTO> listarTodos(){
		List<GastoEntity> gastos = gastoRespository.findAll();
		return gastos.stream().map(GastoDTO::new).toList();
	}
	

	public void inserir(GastoDTO gastoDTO) {
		GastoEntity gasto = new GastoEntity(gastoDTO);
		gastoRespository.save(gasto);
	}
	
	
	public GastoDTO update(GastoDTO gastoDTO) {
		GastoEntity gasto = new GastoEntity(gastoDTO);
		return new GastoDTO(gastoRespository.save(gasto));
	}
	
	
	
	
	
}
