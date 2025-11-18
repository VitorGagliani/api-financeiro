package com.vgs.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vgs.gerenciador.DTO.CategoriaDTO;
import com.vgs.gerenciador.DTO.GastoDTO;
import com.vgs.gerenciador.entity.CategoriaEntity;
import com.vgs.gerenciador.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	//crud
	
	public List<CategoriaDTO> listar(){
		List<CategoriaEntity> categoria = categoriaRepository.findAll();
		return categoria.stream().map(CategoriaDTO::new).toList();
	}
	
	public void inserir(CategoriaDTO categoriaDTO) {
		CategoriaEntity categoria = new CategoriaEntity(categoriaDTO);
		categoriaRepository.save(categoria);
	}
	
	public CategoriaDTO update(CategoriaDTO categoriaDTO) {
		CategoriaEntity categoria = new CategoriaEntity(categoriaDTO);
		return new CategoriaDTO(categoriaRepository.save(categoria));
	}
	
}
