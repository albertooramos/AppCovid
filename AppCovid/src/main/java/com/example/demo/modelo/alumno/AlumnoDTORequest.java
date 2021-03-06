package com.example.demo.modelo.alumno;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class AlumnoDTORequest{

	private String nombre;

	
	
	public AlumnoDTORequest(String nombre  ) {
		this.nombre = nombre;

	}
	
	public AlumnoDTORequest() {

	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
