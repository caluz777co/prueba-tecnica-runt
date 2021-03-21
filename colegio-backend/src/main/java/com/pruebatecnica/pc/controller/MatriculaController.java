package com.pruebatecnica.pc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pc.model.Matricula;
import com.pruebatecnica.pc.service.MatriculaService;

@RestController
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	@GetMapping("/matriculas")
	public ResponseEntity<List<Matricula>> obtenermatriculas() {
		return ResponseEntity.ok().body(matriculaService.obtenerMatriculas());
	}
	
	@GetMapping("/matricula")
	public ResponseEntity<Matricula> obtenerMatriculaId(@PathVariable long id) {
		return ResponseEntity.ok().body(this.matriculaService.obtenerMatriculaId(id));
	}
	
	@PostMapping("/matriculas")
	public ResponseEntity<Matricula> crearMatricula(@RequestBody Matricula matricula) {
		return ResponseEntity.ok().body(this.matriculaService.crearMatricula(matricula));
	}
	
	@PutMapping("/matriculas/{id}")
	public ResponseEntity<Matricula> actualizarMatricula(@PathVariable long id, @RequestBody Matricula matricula) {
		matricula.setId(id);
		return ResponseEntity.ok().body(this.matriculaService.actualizarMatricula(matricula));
	}
	
	@DeleteMapping("matriculas/{id}")
	public HttpStatus borrarMatricula(@PathVariable long id) {
		this.matriculaService.borrarMatricula(id);
		return HttpStatus.OK;
	}
}
