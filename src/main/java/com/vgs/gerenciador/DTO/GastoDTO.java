package com.vgs.gerenciador.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.vgs.gerenciador.entity.CategoriaEntity;
import com.vgs.gerenciador.entity.GastoEntity;
import com.vgs.gerenciador.enums.FormaPagamento;
import com.vgs.gerenciador.enums.Tipo;


public class GastoDTO {

	private Long id;	
	private BigDecimal valor;	
	private String descricao;
	private LocalDate data;
	private Tipo tipo;
	private CategoriaEntity categoria;
	private Long categoriaId;
	private FormaPagamento forma;
	
	
	public GastoDTO(GastoEntity gasto) {
        
        this.id = gasto.getId();
        this.valor = gasto.getValor();
        this.descricao = gasto.getDescricao();
        this.data = gasto.getData();
        this.forma = gasto.getForma();
        this.tipo = gasto.getTipo(); // Tipo (Enum)
        this.categoria = gasto.getCategoria(); 
        
    }
	
	public GastoDTO() {
		
	}
	
	
	
	
	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
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

	
	public Tipo getTipo() { 
	    return tipo;
	}
	

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public FormaPagamento getForma() {
		return forma;
	}

	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}
	
	
	
	
	
	
	
}
