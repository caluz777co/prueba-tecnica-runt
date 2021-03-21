package com.pruebatecnica.pc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

	private static final long serialVersionUID = 6700822576668271926L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "estudiante_id")
	private Long estudianteId;

	@Column(name = "asignatura_id")
	private Long asignaturaId;

	public Matricula(Long estudianteId, Long asignaturaId) {
		super();
		this.estudianteId = estudianteId;
		this.asignaturaId = asignaturaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Long estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Long getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(Long asignaturaId) {
		this.asignaturaId = asignaturaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignaturaId == null) ? 0 : asignaturaId.hashCode());
		result = prime * result + ((estudianteId == null) ? 0 : estudianteId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Matricula other = (Matricula) obj;
		if (asignaturaId == null) {
			if (other.asignaturaId != null)
				return false;
		} else if (!asignaturaId.equals(other.asignaturaId))
			return false;
		if (estudianteId == null) {
			if (other.estudianteId != null)
				return false;
		} else if (!estudianteId.equals(other.estudianteId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", estudianteId=" + estudianteId + ", asignaturaId=" + asignaturaId + "]";
	}
	
}
