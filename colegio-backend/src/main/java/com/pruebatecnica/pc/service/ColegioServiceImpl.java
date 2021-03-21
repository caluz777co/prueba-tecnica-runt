package com.pruebatecnica.pc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pc.constants.ConstantesGenerales;
import com.pruebatecnica.pc.exception.ResourceNotFoundException;
import com.pruebatecnica.pc.model.Colegio;
import com.pruebatecnica.pc.repository.ColegioRepository;

@Service
@Transactional
public class ColegioServiceImpl implements ColegioService {

	@Autowired
	private ColegioRepository colegioRepository;

	@Override
	public Colegio crearColegio(Colegio colegio) {
		return colegioRepository.save(colegio);
	}

	@Override
	public Colegio actualizarColegio(Colegio colegio) {
		Optional<Colegio> colegioDb = this.colegioRepository.findById(colegio.getId());

		if (colegioDb.isPresent()) {
			Colegio actColegio = colegioDb.get();
			actColegio.setId(colegio.getId());
			actColegio.setNombre(colegio.getNombre());
			colegioRepository.save(actColegio);
			return actColegio;
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.COLEGIO + colegio.getId());
		}
	}

	@Override
	public List<Colegio> obtenerColegios() {
		return this.colegioRepository.findAll();
	}

	@Override
	public Colegio obtenerColegioId(Long colegioId) {
		Optional<Colegio> colegioDb = this.colegioRepository.findById(colegioId);

		if (colegioDb.isPresent()) {
			return colegioDb.get();
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.COLEGIO + colegioId);
		}
	}

	@Override
	public void borrarColegio(Long colegioId) {
		Optional<Colegio> colegioDb = this.colegioRepository.findById(colegioId);

		if (colegioDb.isPresent()) {
			this.colegioRepository.delete(colegioDb.get());
		} else {
			throw new ResourceNotFoundException(ConstantesGenerales.NO_SE_ENCUENTRA + ConstantesGenerales.COLEGIO + colegioId);
		}

	}

}
