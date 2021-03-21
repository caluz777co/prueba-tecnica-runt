package com.pruebatecnica.pc.service;

import java.util.List;

import com.pruebatecnica.pc.model.Asignatura;

public interface AsignaturaService {
	
	Asignatura crearAsignatura(Asignatura asignatura);

	Asignatura actualizarAsignatura(Asignatura asignatura);

	List<Asignatura> obtenerAsignaturas();

	Asignatura obtenerAsignaturaId(Long asignaturaId);

	void borrarAsignatura(Long asignaturaId);
}
