package com.vgs.gerenciador.DTO;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.vgs.gerenciador.entity.CategoriaEntity;
import com.vgs.gerenciador.entity.GastoEntity;


public class GastoDTO {

	private Long id;	
	private Double valor;	
	private String descricao;
	private LocalDate data;
	private CategoriaEntity categoria;
	
	
	public GastoDTO(GastoEntity gasto) {
		BeanUtils.copyProperties(gasto, this);
		
	}
	
	public GastoDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public CategoriaEntity getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	
	
	
}
