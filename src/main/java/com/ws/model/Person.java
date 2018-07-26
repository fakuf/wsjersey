package com.ws.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long Dni;
	private String surname;
	private String name;
	private String age;
	
	public Person() {}
	
	public Person(String surname, String name, String age) {
		super();
		this.surname = surname;
		this.name = name;
		this.age = age;
	}
	
	public Person(Long dni, String surname, String name, String age) {
		super();
		Dni = dni;
		this.surname = surname;
		this.name = name;
		this.age = age;
	}
	
	public Long getDni() {
		return Dni;
	}
	public void setDni(Long dni) {
		Dni = dni;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
		Person other = (Person) obj;
		if (Dni == null) {
			if (other.Dni != null)
				return false;
		} else if (!Dni.equals(other.Dni))
			return false;
		return true;
	}
}
