package com.pruebatecnica.pc.service;

import java.util.List;

import com.pruebatecnica.pc.model.Curso;

public interface CursoService {
	
	Curso crearCurso(Curso curso);

	Curso actualizarCurso(Curso curso);

	List<Curso> obtenerCursos();

	Curso obtenerCursoId(Long cursoId);

	void borrarCurso(Long cursoId);
}
