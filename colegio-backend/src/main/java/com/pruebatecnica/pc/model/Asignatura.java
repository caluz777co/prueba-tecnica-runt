package com.pruebatecnica.pc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "asignatura")
@JsonIgnoreProperties({"estudiantes"})
public class Asignatura implements Serializable {

	private static final long serialVersionUID = 5648495186327867446L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;
	
	@ManyToMany(mappedBy = "asignaturas")
    private Set<Estudiante> estudiantes;
	
	@ManyToOne()
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	//Constructor
	
	public Asignatura() {
		super();
	}
	
	public Asignatura(String nombre, Profesor profesor, Set<Estudiante> estudiantes, Curso curso) {
		super();
		this.nombre = nombre;
		this.profesor = profesor;
		this.estudiantes = estudiantes;
		this.curso = curso;
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	//HashCode and Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((estudiantes == null) ? 0 : estudiantes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (estudiantes == null) {
			if (other.estudiantes != null)
				return false;
		} else if (!estudiantes.equals(other.estudiantes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}
	
	//toString

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", profesor=" + profesor + ", estudiantes=" + estudiantes
				+ ", curso=" + curso + "]";
	}
	
}
