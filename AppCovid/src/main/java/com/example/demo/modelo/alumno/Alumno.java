package com.example.demo.modelo.alumno;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.modelo.profesor.Profesor;
import com.example.demo.modelo.responsable.Responsable;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno")
public class Alumno {
	@Id
	@ApiModelProperty(value = "identificador del alumno", dataType = "String", position = 1, example = "1")
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@ApiModelProperty(value = "dni del alumno", dataType = "String", position = 2, example = "17635875K")
	@Column(name = "dni")
	private String dni;

	@ApiModelProperty(value = "nombre del alumno", dataType = "String", position = 3, example = "Alberto")
	@Column(name = "nombre")
	private String nombre;

	@ApiModelProperty(value = "fecha de nacimiento del alumno", dataType = "String", position = 4, example = "08/11/1995")
	@Column(name = "fechaNacimiento")
	private String fechaNacimiento;

	@ApiModelProperty(value = "telefono del alumno", dataType = "String", position = 5, example = "658962130")
	@Column(name = "telefono")
	private String telefono;

	@ApiModelProperty(value = "direccion del alumno", dataType = "String", position = 6, example = "Logroño, Calle: calle gran via, N: 5, Piso:A")
	@Column(name = "direccion")
	private String direccion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@ApiModelProperty(value = "identificador del responsable", dataType = "Long", position = 7, example = "2")
	@JoinColumn(name = "id", unique = true, nullable = false)
	private Responsable responsable;

	@OneToOne(cascade = CascadeType.ALL)
	@ApiModelProperty(value = "identificador del profesor", dataType = "String", position = 8, example = "3")
	@JoinColumn(name = "id", unique = true, nullable = false)
	private Profesor profesor;

	public Alumno() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
	
	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Alumno(String id, String dni, String nombre, String fechaNacimiento, String telefono, String direccion) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
	

}