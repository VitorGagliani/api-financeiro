package com.vgs.gerenciador.DTO;

import java.math.BigDecimal;
import java.util.List;

public class DashboardDTO {
    
   
    private BigDecimal totalEntradas;
    private BigDecimal totalSaidas;
    private List<BigDecimal> totaisPorMes;
    private BigDecimal diferenca;
    private String maiorGastoCategoria;

    
    public DashboardDTO() {
        
    }

  
    public DashboardDTO(BigDecimal totalEntradas, BigDecimal totalSaidas, String maiorGastoCategoria, List<BigDecimal> totaisPorMes) {
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
        this.maiorGastoCategoria = maiorGastoCategoria;
        this.totaisPorMes = totaisPorMes;
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

	public BigDecimal getDiferenca() {
    	return diferenca;
    }

    // 4. Setters
    
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