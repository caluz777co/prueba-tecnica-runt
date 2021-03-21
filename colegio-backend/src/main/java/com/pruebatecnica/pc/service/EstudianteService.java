package com.pruebatecnica.pc.service;

import java.util.List;

import javax.transaction.Transactional;

import com.pruebatecnica.pc.model.Estudiante;

@Transactional
public interface EstudianteService {
	
	Estudiante crearEstudiante(Estudiante estudiante);

	Estudiante actualizarEstudiante(Estudiante estudiante);

	List<Estudiante> obtenerEstudiantes();

	Estudiante obtenerEstudianteId(Long estudianteId);

	void borrarEstudiante(Long estudianteId);
	
	List<Estudiante> getDescription(Long id);
}
