package com.vgs.gerenciador.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class EntradaDTO {
	
	private BigDecimal totalEntradas;
	private List<BigDecimal> totaisPorMes;
	 private Map<Object, BigDecimal> maiorMes;
	
	
	public EntradaDTO(BigDecimal totalEntradas, List<BigDecimal> totaisPorMes, Map<Object, BigDecimal> maiorMes) {
		super();
		this.totalEntradas = totalEntradas;
		this.totaisPorMes = totaisPorMes;
		this.maiorMes = maiorMes;
	}
	public BigDecimal getTotalEntradas() {
		return totalEntradas;
	}
	public void setTotalEntradas(BigDecimal totalEntradas) {
		this.totalEntradas = totalEntradas;
	}
	
	
	public Map<Object, BigDecimal> getMaiorMes() {
		return maiorMes;
	}
	public void setMaiorMes(Map<Object, BigDecimal> maiorMes) {
		this.maiorMes = maiorMes;
	}
	public List<BigDecimal> getTotaisPorMes() {
		return totaisPorMes;
	}
	public void setTotaisPorMes(List<BigDecimal> totaisPorMes) {
		this.totaisPorMes = totaisPorMes;
	}
	
	
	
	
}

