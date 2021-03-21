package com.pruebatecnica.pc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pc.constants.ConstantesGenerales;
import com.pruebatecnica.pc.exception.ResourceNotFoundException;
import com.pruebatecnica.pc.model.Asignatura;
import com.pruebatecnica.pc.repository.AsignaturaRepository;

@Service
@Transactional
public class AsignaturaServiceImpl implements AsignaturaService {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public Asignatura crearAsignatura(Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}

	@Override
	public Asignatura actualizarAsignatura(Asignatura asignatura) {
		Optional<Asignatura> asignaturaDb = this.asignaturaRepository.findById(asignatura.getId());

		if (asignaturaDb.isPresent()) {
			Asignatura actAsignatura = asignaturaDb.get();
			actAsignatura.setId(asignatura.getId());
			actAsignatura.setNombre(asignatura.getNombre());
			actAsignatura.setCurso(asignatura.getCurso());
			actAsignatura.setEstudiantes(asignatura.getEstudiantes());
			actAsignatura.setProfesor(asignatura.getProfesor());
			asignaturaRepository.save(actAsignatura);
			return actAsignatura;
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.ASIGNATURA + asignatura.getId());
		}
	}

	@Override
	public List<Asignatura> obtenerAsignaturas() {
		return this.asignaturaRepository.findAll();
	}

	@Override
	public Asignatura obtenerAsignaturaId(Long asignaturaId) {
		Optional<Asignatura> asignaturaDb = this.asignaturaRepository.findById(asignaturaId);

		if (asignaturaDb.isPresent()) {
			return asignaturaDb.get();
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.ASIGNATURA + asignaturaId);
		}
	}

	@Override
	public void borrarAsignatura(Long asignaturaId) {
		Optional<Asignatura> asignaturaDb = this.asignaturaRepository.findById(asignaturaId);

		if (asignaturaDb.isPresent()) {
			this.asignaturaRepository.delete(asignaturaDb.get());
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.ASIGNATURA + asignaturaId);
		}
	}
}
