package com.example.demo.persistencia.services;

import java.util.Optional;
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import com.example.demo.modelo.profesor.Profesor;
import com.example.demo.persistencia.repositories.ProfesorRepository;


public class ProfesorService extends BaseService<Profesor, String, ProfesorRepository> {

	public void cambiarNombre(String identificador, String nombre) {
		Optional<Profesor> pOptional = this.repositorio.findById(identificador);
		if (pOptional.isPresent()) {
			Profesor p = pOptional.get();
			p.setNombre(nombre);
			this.repositorio.save(p);
		}
	}

	public Page<Profesor> encontrarPorNombre(String nombre, Pageable p) {
		return this.repositorio.findByName(nombre, p);
	}

	public Optional<Profesor> encontrarPorId(String id) {
		return this.repositorio.findById(id);
	}

}
