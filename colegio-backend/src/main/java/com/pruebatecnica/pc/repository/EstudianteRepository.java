package com.pruebatecnica.pc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebatecnica.pc.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
	@Query(nativeQuery = true, value=" SELECT id, nombre FROM estudiante_asignatura eas\n" + 
			"JOIN  estudiante est  ON eas.estudiante_id = est.id WHERE eas.asignatura_id = ?1")
	public List<Estudiante>findDescription(Long id);
}
