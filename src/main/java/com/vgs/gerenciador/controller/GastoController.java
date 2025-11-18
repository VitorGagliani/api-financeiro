package com.vgs.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgs.gerenciador.DTO.GastoDTO;
import com.vgs.gerenciador.service.GastoService;

@RestController
@RequestMapping(value = "/gasto")
public class GastoController {
	
	@Autowired
	private GastoService gasto;
	
	@GetMapping
	public List<GastoDTO> listar(){
		return gasto.listarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody GastoDTO gastoDto) {
		gasto.inserir(gastoDto);
	}
	
	@PutMapping
	public GastoDTO alterar(GastoDTO gastoDto) {
		return gasto.update(gastoDto);
	}

}
