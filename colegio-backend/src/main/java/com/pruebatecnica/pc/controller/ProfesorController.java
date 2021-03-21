package com.pruebatecnica.pc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pc.model.Profesor;
import com.pruebatecnica.pc.service.ProfesorService;

@CrossOrigin
@RestController
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/profesores")
	public ResponseEntity<List<Profesor>> obtenerProfesores() {
		return ResponseEntity.ok().body(profesorService.obtenerProfesores());
	}
	
	@GetMapping("/profesor")
	public ResponseEntity<Profesor> obtenerProfesorId(@PathVariable long id) {
		return ResponseEntity.ok().body(this.profesorService.obtenerProfesorId(id));
	}
	
	@PostMapping("/profesor")
	public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
		return ResponseEntity.ok().body(this.profesorService.crearProfesor(profesor));
	}
	
	@PutMapping("/profesor/{id}")
	public ResponseEntity<Profesor> actualizarProfesor(@PathVariable long id, @RequestBody Profesor profesor) {
		profesor.setId(id);
		return ResponseEntity.ok().body(this.profesorService.actualizarProfesor(profesor));
	}
	
	@DeleteMapping("profesor/{id}")
	public HttpStatus borrarProfesor(@PathVariable long id) {
		this.profesorService.borrarProfesor(id);
		return HttpStatus.OK;
	}
}
