package com.vgs.gerenciador.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public record SaidaDTO(BigDecimal totalSaidas, List<BigDecimal> totaisPorMes,
 Map<Object, BigDecimal> maiorMes,List<Object> todasSaidas) {

}
