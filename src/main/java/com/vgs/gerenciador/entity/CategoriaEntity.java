package com.vgs.gerenciador.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.vgs.gerenciador.DTO.CategoriaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AQRCAD")
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	public CategoriaEntity(CategoriaDTO categoria) {
		BeanUtils.copyProperties(categoria, this);
	}
	
	
	
	public CategoriaEntity() {
		
	}
	
	//getters e setters

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

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaEntity other = (CategoriaEntity) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}
	
	
}
