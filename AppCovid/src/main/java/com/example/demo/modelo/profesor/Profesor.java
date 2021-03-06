package com.example.demo.modelo.profesor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Profesor")
public class Profesor {

	@Id
	@ApiModelProperty(value = "identificador del alumno", dataType = "String", position = 1, example = "1")
    @Column(name = "id",unique=true, nullable = false)
	private String id;
	
	@ApiModelProperty(value = "nombre del alumno", dataType = "String", position = 2, example = "ALberto")
	@Column(name="nombre")
	private String nombre;

	@ApiModelProperty(value = "telefono del alumno", dataType = "String", position = 3, example = "652315986")
	@Column(name="telefono")
	private String telefono;

	public Profesor(String id, String nombre, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;

	}

	public Profesor() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}

}
