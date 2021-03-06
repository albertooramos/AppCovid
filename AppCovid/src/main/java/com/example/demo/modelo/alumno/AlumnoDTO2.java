package com.example.demo.modelo.alumno;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class AlumnoDTO2 implements Serializable{

	private String nombre;

	
	
	public AlumnoDTO2(String idAlumno, String nombre, String fechaNacimiento, String telefono, String direccion) {
		this.nombre = nombre;

	}
	
	public AlumnoDTO2() {

	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
