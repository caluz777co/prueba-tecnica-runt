package com.pruebatecnica.pc.service;

import java.util.List;

import com.pruebatecnica.pc.model.Colegio;

public interface ColegioService {
	
	Colegio crearColegio(Colegio colegio);

	Colegio actualizarColegio(Colegio colegio);

	List<Colegio> obtenerColegios();

	Colegio obtenerColegioId(Long colegioId);

	void borrarColegio(Long colegioId);

}
