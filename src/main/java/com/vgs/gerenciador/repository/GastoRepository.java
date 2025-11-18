package com.vgs.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vgs.gerenciador.entity.GastoEntity;

public interface GastoRepository  extends JpaRepository<GastoEntity, Long>{

	
}
