package com.example.demo.modelo.alumno;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AlumnoDTO implements Serializable{

	private String id;
	private String nombre;
	private String fechaNacimiento;
	private String telefono;
	private String direccion;
	
	
	public AlumnoDTO(String idAlumno, String nombre, String fechaNacimiento, String telefono, String direccion) {
		this.id = idAlumno;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public AlumnoDTO() {

	}

	public String getIdAlumno() {
		return id;
	}

	public void setIdAlumno(String idAlumno) {
		this.id = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
