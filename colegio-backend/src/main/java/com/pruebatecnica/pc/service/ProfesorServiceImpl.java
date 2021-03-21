package com.pruebatecnica.pc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pc.constants.ConstantesGenerales;
import com.pruebatecnica.pc.exception.ResourceNotFoundException;
import com.pruebatecnica.pc.model.Profesor;
import com.pruebatecnica.pc.repository.ProfesorRepository;

@Service
@Transactional
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Override
	public Profesor crearProfesor(Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		Optional<Profesor> profesorDb = this.profesorRepository.findById(profesor.getId());

		if (profesorDb.isPresent()) {
			Profesor actProfesor = profesorDb.get();
			actProfesor.setId(profesor.getId());
			actProfesor.setNombre(profesor.getNombre());
			//actProfesor.setAsignaturas(profesor.getAsignaturas());
			profesorRepository.save(actProfesor);
			return actProfesor;
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA+ ConstantesGenerales.PROFESOR + profesor.getId());
		}
	}

	@Override
	public List<Profesor> obtenerProfesores() {
		return this.profesorRepository.findAll();
	}

	@Override
	public Profesor obtenerProfesorId(Long profesorId) {
		Optional<Profesor> profesorDb = this.profesorRepository.findById(profesorId);

		if (profesorDb.isPresent()) {
			return profesorDb.get();
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.PROFESOR + profesorId);
		}
	}

	@Override
	public void borrarProfesor(Long profesorId) {
		Optional<Profesor> profesorDb = this.profesorRepository.findById(profesorId);

		if (profesorDb.isPresent()) {
			this.profesorRepository.delete(profesorDb.get());
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.PROFESOR + profesorId);
		}	
	}

}
