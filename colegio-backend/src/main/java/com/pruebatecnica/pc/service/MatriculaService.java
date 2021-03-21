package com.pruebatecnica.pc.service;

import java.util.List;

import com.pruebatecnica.pc.model.Matricula;

public interface MatriculaService {
	
	Matricula crearMatricula(Matricula matricula);

	Matricula actualizarMatricula(Matricula matricula);

	List<Matricula> obtenerMatriculas();

	Matricula obtenerMatriculaId(Long matriculaId);

	void borrarMatricula(Long matriculaId);
}
