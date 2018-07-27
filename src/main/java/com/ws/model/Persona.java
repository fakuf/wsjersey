package com.ws.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
@Entity
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	
	private Long Dni;
	
	@NotNull(message="El apellido no puede ser null")
	private String apellido;
	
	@NotNull(message="El nombre no puede ser null")
	private String nombre;
	
	@NotNull(message="La edad no puede ser null")
	private String edad;
	
	public Persona() {}

	public Persona(Long dni, String apellido, String nombre, String edad) {
		super();
		Dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Long getDni() {
		return Dni;
	}

	public void setDni(@Digits(integer=8, fraction = 0, message = "(nuDocumento) Cantidad de caracteres ingresados distinto a 8") Long dni) {
		Dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dni == null) ? 0 : Dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (Dni == null) {
			if (other.Dni != null)
				return false;
		} else if (!Dni.equals(other.Dni))
			return false;
		return true;
	}
	
	
}
