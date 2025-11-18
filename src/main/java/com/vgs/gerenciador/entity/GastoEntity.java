package com.vgs.gerenciador.entity;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.vgs.gerenciador.DTO.GastoDTO;
import com.vgs.gerenciador.entity.CategoriaEntity;

import jakarta.annotation.Generated;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ARQGASTO")
public class GastoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nullable
	private Long id;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@ManyToOne
	private CategoriaEntity categoria;
	
	
//	 @ManyToOne
//	    @JoinColumn(name = "categoria_id", nullable = false) // ✔ obrigatório
//	private Categoria categoria;
	
	public GastoEntity(GastoDTO gasto) {
		BeanUtils.copyProperties(gasto, this);
	}
	
	public GastoEntity() {
		
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

	@Override
	public int hashCode() {
		return Objects.hash(categoria, data, descricao, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GastoEntity other = (GastoEntity) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(data, other.data)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(valor, other.valor);
	}
	
	

	


	



	
	

}
