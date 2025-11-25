package com.vgs.gerenciador.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.vgs.gerenciador.entity.CategoriaEntity;
import com.vgs.gerenciador.entity.GastoEntity;
import com.vgs.gerenciador.enums.Tipo;
import com.vgs.gerenciador.DTO.CategoriaDTO;
import com.vgs.gerenciador.DTO.DashboardDTO;
import com.vgs.gerenciador.DTO.EntradaDTO;
import com.vgs.gerenciador.DTO.GastoDTO;
import com.vgs.gerenciador.repository.CategoriaRepository;
import com.vgs.gerenciador.repository.GastoRepository;

@Service
public class GastoService {
	
	@Autowired
	private GastoRepository gastoRespository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//crud

	public List<GastoDTO> listarTodos(){
		List<GastoEntity> gastos = gastoRespository.findAll();
		return gastos.stream().map(GastoDTO::new).toList();
	}
	
	public List<CategoriaDTO> listarCategorias(){
		List<CategoriaEntity> categoria = categoriaRepository.findAll();
		return categoria.stream().map(CategoriaDTO::new).toList();
	}

	public void inserir(GastoDTO gastoDTO) {
		GastoEntity gasto = new GastoEntity(gastoDTO);
		gastoRespository.save(gasto);
	}
	
	
	public GastoDTO update(GastoDTO gastoDTO) {
		GastoEntity gasto = new GastoEntity(gastoDTO);
		return new GastoDTO(gastoRespository.save(gasto));
	}
	
	
	//para o dashboard da API
	
	
	public DashboardDTO getResumoDashboard() {
		List<GastoDTO> todosGastos = listarTodos(); 
    
       
        
        
        
        BigDecimal totalEntradas = BigDecimal.ZERO;
        BigDecimal totalSaidas = BigDecimal.ZERO;

       
      
    

        Map<String, BigDecimal> gastosPorCategoria = new java.util.HashMap<>();
        
        
        Map<Object, BigDecimal> totalPorCategoria = todosGastos.stream()
        		.filter(g -> g.getTipo() == Tipo.SAIDA)
        .collect(Collectors.groupingBy(g -> g.getCategoria().getDescricao(), 
        		Collectors.reducing(BigDecimal.ZERO, GastoDTO::getValor, BigDecimal::add)
        		));
        
    


        for (GastoDTO gasto : todosGastos) {
            if (gasto.getTipo() == Tipo.ENTRADA) { 
        
                totalEntradas = totalEntradas.add(gasto.getValor());
            } else if (gasto.getTipo() == Tipo.SAIDA) {
                
                totalSaidas = totalSaidas.add(gasto.getValor());

                String categoriaDescricao = gasto.getCategoria() != null 
                                            ? gasto.getCategoria().getDescricao() 
                                            : "Sem Categoria";
                
                BigDecimal gastoAtual = gastosPorCategoria.getOrDefault(categoriaDescricao, BigDecimal.ZERO);

                gastosPorCategoria.put(categoriaDescricao, gastoAtual.add(gasto.getValor()));
            }
        }
        
        
        for(GastoDTO gasto : todosGastos) {
        	
        }
        
        List<BigDecimal> totaisPorMes = new ArrayList<>(Collections.nCopies(12, BigDecimal.ZERO));
        List<BigDecimal> totaisPorMesSaida = new ArrayList<>(Collections.nCopies(12, BigDecimal.ZERO));

        
        
        //pega as entradas por mes
        for (int mes = 1; mes <= 12; mes++) {
        	 final int mesFiltro = mes;
            BigDecimal total = todosGastos.stream()
                .filter(g -> g.getData().getMonthValue() == mesFiltro && g.getTipo() == Tipo.ENTRADA)
                .map(GastoDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            totaisPorMes.set(mes - 1, total); //menos um pq vetor ta um a frente
        }
        
        
        //pega as saidas por mes
        for (int mes = 1; mes <= 12; mes++) {
       	 final int mesFiltro = mes;
           BigDecimal total = todosGastos.stream()
               .filter(g -> g.getData().getMonthValue() == mesFiltro && g.getTipo() == Tipo.SAIDA)
               .map(GastoDTO::getValor)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
           
           totaisPorMesSaida.set(mes - 1, total); //menos um pq vetor ta um a frente
       }
        
 
        //pega a categoria com maior gasto
        String maiorGastoCategoria = gastosPorCategoria.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhuma Saída Registrada");

        return new DashboardDTO(totalEntradas, totalSaidas, maiorGastoCategoria, totaisPorMes, totaisPorMesSaida, totalPorCategoria);

    }
	
	
	public EntradaDTO entradasDash() {
		List<GastoDTO> todosGastos = listarTodos(); 
		
		 BigDecimal totalEntradas = BigDecimal.ZERO;
	        
		
		List<BigDecimal> totaisPorMes = new ArrayList<>(Collections.nCopies(12, BigDecimal.ZERO));
	  

		
		//pega as entradas por mes
        for (int mes = 1; mes <= 12; mes++) {
        	 final int mesFiltro = mes;
            BigDecimal total = todosGastos.stream()
                .filter(g -> g.getData().getMonthValue() == mesFiltro && g.getTipo() == Tipo.ENTRADA)
                .map(GastoDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            totaisPorMes.set(mes - 1, total); //menos um pq vetor ta um a frente
        }
        
        
        //pegar todos gastos
        for(GastoDTO gasto : todosGastos) {
        		if(gasto.getTipo() == Tipo.ENTRADA) {
        			totalEntradas = totalEntradas.add(gasto.getValor());
        		}
        }
        
        Map<Object, BigDecimal> maiorMes = todosGastos.stream()
        		.filter(g -> g.getTipo() == Tipo.SAIDA)
        .collect(Collectors.groupingBy(g -> g.getData().getMonth(), 
        		Collectors.reducing(BigDecimal.ZERO, GastoDTO::getValor, BigDecimal::add)
        		));
		
		return new EntradaDTO (totalEntradas, totaisPorMes, maiorMes);
	}
	
	
	
	
	
}
