package com.vgs.gerenciador.DTO;

import java.time.LocalDate;
import java.util.Date;

public class FiltraDataDTO {
	
	private LocalDate inicio = null;
	private LocalDate fim = null;
	
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public FiltraDataDTO(LocalDate inicio, LocalDate fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public FiltraDataDTO() {
		
	}

}
