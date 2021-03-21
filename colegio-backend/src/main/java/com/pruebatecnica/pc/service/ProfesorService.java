package com.pruebatecnica.pc.service;

import java.util.List;

import com.pruebatecnica.pc.model.Profesor;

public interface ProfesorService {
	
	Profesor crearProfesor(Profesor profesor);

	Profesor actualizarProfesor(Profesor profesor);

	List<Profesor> obtenerProfesores();

	Profesor obtenerProfesorId(Long profesorId);

	void borrarProfesor(Long profesorId);
}
