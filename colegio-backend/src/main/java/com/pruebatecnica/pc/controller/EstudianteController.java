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

import com.pruebatecnica.pc.model.Estudiante;
import com.pruebatecnica.pc.service.EstudianteService;

@CrossOrigin
@RestController
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/estudiantes")
	public ResponseEntity<List<Estudiante>> obtenerEstudiantes() {
		return ResponseEntity.ok().body(estudianteService.obtenerEstudiantes());
	}
	
	@GetMapping("/listarEstudiantes/{id}")
	public ResponseEntity<List<Estudiante>> listarEstudiantes(@PathVariable long id) {
		return ResponseEntity.ok().body(estudianteService.getDescription(id));
	}
	
	@GetMapping("/estudiante")
	public ResponseEntity<Estudiante> obtenerEstudianteId(@PathVariable long id) {
		return ResponseEntity.ok().body(this.estudianteService.obtenerEstudianteId(id));
	}
	
	@PostMapping("/estudiantes")
	public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante Estudiante) {
		return ResponseEntity.ok().body(this.estudianteService.crearEstudiante(Estudiante));
	}
	
	@PutMapping("/estudiantes/{id}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable long id, @RequestBody Estudiante Estudiante) {
		Estudiante.setId(id);
		return ResponseEntity.ok().body(this.estudianteService.actualizarEstudiante(Estudiante));
	}
	
	@DeleteMapping("estudiantes/{id}")
	public HttpStatus borrarEstudiante(@PathVariable long id) {
		this.estudianteService.borrarEstudiante(id);
		return HttpStatus.OK;
	}
}
