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

import com.pruebatecnica.pc.service.ColegioService;
import com.pruebatecnica.pc.model.Colegio;

@RestController
public class ColegioController {
	
	@Autowired
	private ColegioService colegioService;
	
	@GetMapping("/colegios")
	public ResponseEntity<List<Colegio>> obtenerColegios() {
		return ResponseEntity.ok().body(colegioService.obtenerColegios());
	}
	
	@GetMapping("/colegio")
	public ResponseEntity<Colegio> obtenerColegioId(@PathVariable long id) {
		return ResponseEntity.ok().body(this.colegioService.obtenerColegioId(id));
	}
	
	@PostMapping("/colegios")
	public ResponseEntity<Colegio> crearColegio(@RequestBody Colegio colegio) {
		return ResponseEntity.ok().body(this.colegioService.crearColegio(colegio));
	}
	
	@PutMapping("/colegios/{id}")
	public ResponseEntity<Colegio> actualizarColegio(@PathVariable long id, @RequestBody Colegio colegio) {
		colegio.setId(id);
		return ResponseEntity.ok().body(this.colegioService.actualizarColegio(colegio));
	}
	
	@DeleteMapping("colegios/{id}")
	public HttpStatus borrarColegio(@PathVariable long id) {
		this.colegioService.borrarColegio(id);
		return HttpStatus.OK;
	}
}
