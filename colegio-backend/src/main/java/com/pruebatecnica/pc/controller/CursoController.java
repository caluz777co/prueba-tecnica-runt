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

import com.pruebatecnica.pc.model.Curso;
import com.pruebatecnica.pc.service.CursoService;

@RestController
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/cursos")
	public ResponseEntity<List<Curso>> obtenerCursos() {
		return ResponseEntity.ok().body(cursoService.obtenerCursos());
	}
	
	@GetMapping("/curso")
	public ResponseEntity<Curso> obtenerCursoId(@PathVariable long id) {
		return ResponseEntity.ok().body(this.cursoService.obtenerCursoId(id));
	}
	
	@PostMapping("/cursos")
	public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
		return ResponseEntity.ok().body(this.cursoService.crearCurso(curso));
	}
	
	@PutMapping("/cursos/{id}")
	public ResponseEntity<Curso> actualizarCurso(@PathVariable long id, @RequestBody Curso curso) {
		curso.setId(id);
		return ResponseEntity.ok().body(this.cursoService.actualizarCurso(curso));
	}
	
	@DeleteMapping("cursos/{id}")
	public HttpStatus borrarCurso(@PathVariable long id) {
		this.cursoService.borrarCurso(id);
		return HttpStatus.OK;
	}
}
