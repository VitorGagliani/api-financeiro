package com.vgs.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgs.gerenciador.DTO.CategoriaDTO;
import com.vgs.gerenciador.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDTO> listar(){
		return categoriaService.listar();
	}
	
	@PostMapping
	public void inserir(@RequestBody CategoriaDTO categoria) {
		categoriaService.inserir(categoria);
	}
	
	@PutMapping
	public CategoriaDTO alterar(CategoriaDTO categoria) {
		return categoriaService.update(categoria);
	}
	
}
