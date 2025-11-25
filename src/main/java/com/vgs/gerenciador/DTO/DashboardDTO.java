package com.vgs.gerenciador.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vgs.gerenciador.entity.CategoriaEntity;

public class DashboardDTO {
    
   
    private BigDecimal totalEntradas;
    private BigDecimal totalSaidas;
    private List<BigDecimal> totaisPorMes;
    private List<BigDecimal> totaisPorMesSaida;
    private BigDecimal diferenca;
    private Map<Object, BigDecimal> totalPorCategoria;
    private String maiorGastoCategoria;

    
    public DashboardDTO() {
        
    }

  
    public DashboardDTO(BigDecimal totalEntradas, BigDecimal totalSaidas, String maiorGastoCategoria, List<BigDecimal> totaisPorMes, List<BigDecimal> totaisPorMesSaida, Map<Object, BigDecimal> totalPorCategoria) {
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
        this.maiorGastoCategoria = maiorGastoCategoria;
        this.totaisPorMes = totaisPorMes;
        this.totaisPorMesSaida = totaisPorMesSaida;
        this.totalPorCategoria = totalPorCategoria;
    }

    // 3. Getters
    
    public BigDecimal getTotalEntradas() {
        return totalEntradas;
    }

    public BigDecimal getTotalSaidas() {
        return totalSaidas;
    }

    public String getMaiorGastoCategoria() {
        return maiorGastoCategoria;
    }
    
    
    
    public List<BigDecimal> getTotaisPorMes() {
        return totaisPorMes;
    }


    public void setTotaisPorMes(List<BigDecimal> totaisPorMes) {
        this.totaisPorMes = totaisPorMes;
    }
    
    

	public List<BigDecimal> getTotaisPorMesSaida() {
		return totaisPorMesSaida;
	}


	public void setTotaisPorMesSaida(List<BigDecimal> totaisPorMesSaida) {
		this.totaisPorMesSaida = totaisPorMesSaida;
	}


	public BigDecimal getDiferenca() {
    	return diferenca;
    }
	
	

    // 4. Setters
    
    public Map<Object, BigDecimal> getTotalPorCategoria() {
		return totalPorCategoria;
	}


	public void setTotalPorCategoria(Map<Object, BigDecimal> totalPorCategoria) {
		this.totalPorCategoria = totalPorCategoria;
	}


	public void setTotalEntradas(BigDecimal totalEntradas) {
        this.totalEntradas = totalEntradas;
    }

    public void setTotalSaidas(BigDecimal totalSaidas) {
        this.totalSaidas = totalSaidas;
    }

    public void setMaiorGastoCategoria(String maiorGastoCategoria) {
        this.maiorGastoCategoria = maiorGastoCategoria; 
    }
    
    public void setDiferenca(BigDecimal diferenca) {
    	this.diferenca = diferenca;
    }
}