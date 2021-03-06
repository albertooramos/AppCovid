package com.example.demo.persistencia.services;

import java.util.Optional;
import com.example.demo.modelo.alumno.Alumno;
import com.example.demo.persistencia.repositories.AlumnoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService extends BaseService<Alumno, String, AlumnoRepository> {
	
	
	public void cambiarNombre(String identificador, String nombre) {
		Optional<Alumno> aOptional = this.repositorio.findById(identificador);
		if (aOptional.isPresent()) {
			Alumno a = aOptional.get();
			a.setNombre(nombre);
			this.repositorio.save(a);
		}
	}

	public Page<Alumno> encontrarPorNombre(String nombre, Pageable a) {
		return this.repositorio.findByName(nombre, a);
	}
	
	public Optional<Alumno> encontrarPorId(String id) {
		return this.repositorio.findById(id);
	}

}
