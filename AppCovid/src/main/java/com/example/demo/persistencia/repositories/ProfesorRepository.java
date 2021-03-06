package com.example.demo.persistencia.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.profesor.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {

	@Query(value = "select p from Profesor p where p.nombre = :name", nativeQuery = true)
	public Page<Profesor> findByName(@Param("name") String name, Pageable pageable);

	public Page<Profesor> findByNombre(String nombre, Pageable pageable);

}
