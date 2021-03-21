package com.pruebatecnica.pc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pc.constants.ConstantesGenerales;
import com.pruebatecnica.pc.exception.ResourceNotFoundException;
import com.pruebatecnica.pc.model.Matricula;
import com.pruebatecnica.pc.repository.MatriculaRepository;

@Service
@Transactional
public class MatriculaServiceImpl implements MatriculaService {
		
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	public Matricula crearMatricula(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}

	@Override
	public Matricula actualizarMatricula(Matricula matricula) {
		Optional<Matricula> matriculaDb = this.matriculaRepository.findById(matricula.getId());

		if (matriculaDb.isPresent()) {
			Matricula actMatricula = matriculaDb.get();
			actMatricula.setId(matricula.getId());
			actMatricula.setAsignaturaId(matricula.getAsignaturaId());
			actMatricula.setEstudianteId(matricula.getEstudianteId());
			matriculaRepository.save(actMatricula);
			return actMatricula;
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA+ ConstantesGenerales.MATRICULA + matricula.getId());
		}
	}

	@Override
	public List<Matricula> obtenerMatriculas() {
		return this.matriculaRepository.findAll();
	}

	@Override
	public Matricula obtenerMatriculaId(Long matriculaId) {
		Optional<Matricula> matriculaDb = this.matriculaRepository.findById(matriculaId);

		if (matriculaDb.isPresent()) {
			return matriculaDb.get();
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.MATRICULA + matriculaId);
		}
	}

	@Override
	public void borrarMatricula(Long matriculaId) {
		Optional<Matricula> matriculaDb = this.matriculaRepository.findById(matriculaId);

		if (matriculaDb.isPresent()) {
			this.matriculaRepository.delete(matriculaDb.get());
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.MATRICULA + matriculaId);
		}
	}
}
