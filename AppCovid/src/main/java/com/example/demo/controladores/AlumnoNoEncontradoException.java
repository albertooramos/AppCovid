package com.example.demo.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlumnoNoEncontradoException extends RuntimeException {

	public AlumnoNoEncontradoException(String identificadorAlumno) {
		super("alumno with "+identificadorAlumno +" could not be retrieved");
	}
	
}
