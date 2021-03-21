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

import com.pruebatecnica.pc.model.Asignatura;
import com.pruebatecnica.pc.service.AsignaturaService;

@CrossOrigin
@RestController
public class AsignaturaController {
	
	@Autowired
	private AsignaturaService asignaturaService;
	
	@GetMapping("/asignaturas")
	public ResponseEntity<List<Asignatura>> obtenerAsignaturas() {
		return ResponseEntity.ok().body(asignaturaService.obtenerAsignaturas());
	}
	
	@GetMapping("/asignatura")
	public ResponseEntity<Asignatura> obtenerAsignaturaId(@PathVariable long id) {
		return ResponseEntity.ok().body(this.asignaturaService.obtenerAsignaturaId(id));
	}
	
	@PostMapping("/asignaturas")
	public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura asignatura) {
		return ResponseEntity.ok().body(this.asignaturaService.crearAsignatura(asignatura));
	}
	
	@PutMapping("/asignaturas/{id}")
	public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable long id, @RequestBody Asignatura asignatura) {
		asignatura.setId(id);
		return ResponseEntity.ok().body(this.asignaturaService.actualizarAsignatura(asignatura));
	}
	
	@DeleteMapping("asignaturas/{id}")
	public HttpStatus borrarAsignatura(@PathVariable long id) {
		this.asignaturaService.borrarAsignatura(id);
		return HttpStatus.OK;
	}
}
