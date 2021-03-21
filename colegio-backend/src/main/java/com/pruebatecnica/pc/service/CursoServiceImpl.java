package com.pruebatecnica.pc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pc.constants.ConstantesGenerales;
import com.pruebatecnica.pc.exception.ResourceNotFoundException;
import com.pruebatecnica.pc.model.Curso;
import com.pruebatecnica.pc.repository.CursoRepository;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso crearCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		Optional<Curso> cursoDb = this.cursoRepository.findById(curso.getId());

		if (cursoDb.isPresent()) {
			Curso actCurso = cursoDb.get();
			actCurso.setId(curso.getId());
			actCurso.setGrado(curso.getGrado());
			actCurso.setSalon(curso.getSalon());
			actCurso.setAsignaturas(curso.getAsignaturas());
			actCurso.setColegio(curso.getColegio());
			cursoRepository.save(actCurso);
			return actCurso;
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.CURSO + curso.getId());
		}
	}

	@Override
	public List<Curso> obtenerCursos() {
		return this.cursoRepository.findAll();
	}

	@Override
	public Curso obtenerCursoId(Long cursoId) {
		Optional<Curso> cursoDb = this.cursoRepository.findById(cursoId);

		if (cursoDb.isPresent()) {
			return cursoDb.get();
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.CURSO + cursoId);
		}
	}

	@Override
	public void borrarCurso(Long cursoId) {
		Optional<Curso> cursoDb = this.cursoRepository.findById(cursoId);

		if (cursoDb.isPresent()) {
			this.cursoRepository.delete(cursoDb.get());
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.CURSO + cursoId);
		}
	}
}
