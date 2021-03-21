package com.pruebatecnica.pc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pc.constants.ConstantesGenerales;
import com.pruebatecnica.pc.exception.ResourceNotFoundException;
import com.pruebatecnica.pc.model.Estudiante;
import com.pruebatecnica.pc.repository.EstudianteRepository;
@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		Optional<Estudiante> estudianteDb = this.estudianteRepository.findById(estudiante.getId());

		if (estudianteDb.isPresent()) {
			Estudiante actEstudiante = estudianteDb.get();
			actEstudiante.setId(estudiante.getId());
			actEstudiante.setNombre(estudiante.getNombre());
			actEstudiante.setAsignaturas(estudiante.getAsignaturas());
			estudianteRepository.save(actEstudiante);
			return actEstudiante;
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA+ ConstantesGenerales.ESTUDIANTE + estudiante.getId());
		}
	}

	@Override
	public List<Estudiante> obtenerEstudiantes() {
		return this.estudianteRepository.findAll();
	}

	@Override
	public Estudiante obtenerEstudianteId(Long estudianteId) {
		Optional<Estudiante> estudianteDb = this.estudianteRepository.findById(estudianteId);

		if (estudianteDb.isPresent()) {
			return estudianteDb.get();
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.ESTUDIANTE + estudianteId);
		}
	}

	@Override
	public void borrarEstudiante(Long estudianteId) {
		Optional<Estudiante> estudianteDb = this.estudianteRepository.findById(estudianteId);

		if (estudianteDb.isPresent()) {
			this.estudianteRepository.delete(estudianteDb.get());
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.ESTUDIANTE + estudianteId);
		}
	}

	@Override
	public List<Estudiante> getDescription(Long id) {					
		return estudianteRepository.findDescription(id);
	}
}
