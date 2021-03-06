package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.example.demo.modelo.alumno.Alumno;
import com.example.demo.modelo.alumno.AlumnoDTO;
import com.example.demo.modelo.alumno.AlumnoDTO2;
import com.example.demo.modelo.alumno.AlumnoDTOConverter;
import com.example.demo.modelo.profesor.Profesor;
import com.example.demo.modelo.responsable.Responsable;
import com.example.demo.persistencia.services.AlumnoService;
import com.example.demo.persistencia.services.ProfesorService;
import com.example.demo.persistencia.services.ResponsableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.persistencia.services.AlumnoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class AlumnoController {

	private static final int pageSize = 20;

	@Autowired
	private AlumnoService as;
	@Autowired
	private ProfesorService ps;
	@Autowired
	private ResponsableService rs;
	@Autowired
	private AlumnoDTOConverter alumnoDTOConverter;

	// a
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> getAlumno(@PathVariable String id) {
		Optional<Alumno> alumnoOptional = as.findById(id);
		if (alumnoOptional.isPresent()) {
			Alumno alumno = alumnoOptional.get();
			return ResponseEntity.status(HttpStatus.OK).body(alumno);
		} else {
			throw new AlumnoNoEncontradoException(id.toString());
		}
	}

	// b
	@GetMapping("/alumnos")
	public ResponseEntity<?> allProducts(@PageableDefault(size = pageSize, page = 0) Pageable pageable) {

		Page<Alumno> paginaAlumno = as.findAll(pageable);
		Page<AlumnoDTO> paginaDTO = paginaAlumno.map(new Function<Alumno, AlumnoDTO>() {
			@Override
			public AlumnoDTO apply(Alumno t) {
				return alumnoDTOConverter.convertAlumnoToAlumnoDTO(t);
			}
		});

		return ResponseEntity.status(HttpStatus.OK).body(paginaDTO);
	}

	// c
	@DeleteMapping("/alumno{idAlumno}")
	public String deleteAlumno(@RequestParam String id) {
		as.deleteById(id);
		return "Ok";
	}

	// d
	@PutMapping("/alumno/{id}")
	public String editAlumno(@PathVariable String id) {
		Optional<Alumno> alumnoOptional = as.findById(id);
		Alumno a = alumnoOptional.get();
		return as.edit(a).toString();

	}

	// e
	@PostMapping("alumno")
	public String postAlumno(@RequestBody Alumno nuevoAlumno) {
		return as.save(nuevoAlumno).toString();

	}

	// f
	@PutMapping("alumno/{idAlumno}/profesor/{idProfesor}")
	public String asociarProfesorAlumno(@PathVariable String idAlumno,@PathVariable String idProfesor) {
		Optional<Alumno> alumnoOptional = as.findById(idAlumno);
		Alumno a = alumnoOptional.get();
		Optional<Profesor> profesorOptional = ps.findById(idProfesor);
		Profesor p = profesorOptional.get();
		a.setProfesor(p);
		return a.toString();

	}

	// g
	@PostMapping(" alumno/{idAlumno}/responsable")
	public String aniadirResponsableAlumno(@PathVariable String idAlumno, @RequestBody Responsable responsable) {
		Optional<Alumno> alumnoOptional = as.findById(idAlumno);
		Alumno a = alumnoOptional.get();
		a.setResponsable(responsable);
		return a.toString();
	}
	
	//h
	@DeleteMapping("alumno/{idAlumno}/responsable/{idResponsable}")
	public String deleteResponsableAlumno(@PathVariable String idAlumno, @PathVariable String idResponsable) {
		Optional<Alumno> alumnoOptional = as.findById(idAlumno);
		Alumno a = alumnoOptional.get();
		Optional<Responsable> responsableOptional = rs.findById(idResponsable);
		Responsable r = responsableOptional.get();
		  if (a.getResponsable()==r) {
	            a.setResponsable(null);
	        }
	        return a.toString();
		
	}

}
