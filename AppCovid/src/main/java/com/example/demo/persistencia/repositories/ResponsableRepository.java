package com.example.demo.persistencia.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.modelo.responsable.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, String> {

	@Query(value = "select r from Responsable r where r.nombre = :name", nativeQuery = true)
	public Page<Responsable> findByName(@Param("name") String name, Pageable pageable);

	public Page<Responsable> findByNombre(String nombre, Pageable pageable);

}
