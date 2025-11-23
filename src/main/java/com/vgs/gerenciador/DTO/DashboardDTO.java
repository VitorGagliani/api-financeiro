package com.vgs.gerenciador.DTO;

import java.math.BigDecimal;

public class DashboardDTO {
    
   
    private BigDecimal totalEntradas;
    private BigDecimal totalSaidas;
    private BigDecimal diferenca;
    private String maiorGastoCategoria;

    
    public DashboardDTO() {
        
    }

  
    public DashboardDTO(BigDecimal totalEntradas, BigDecimal totalSaidas, String maiorGastoCategoria) {
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
        this.maiorGastoCategoria = maiorGastoCategoria;
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