package com.pruebatecnica.pc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.pc.model.Colegio;

public interface ColegioRepository extends JpaRepository<Colegio, Long> {
	
}
