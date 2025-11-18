package com.vgs.gerenciador.DTO;

import org.springframework.beans.BeanUtils;

import com.vgs.gerenciador.entity.CategoriaEntity;

public class CategoriaDTO {

	private Long id;
	private String descricao;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(CategoriaEntity categoria) {
		BeanUtils.copyProperties(categoria, this);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
