package com.example.demo.classes;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animales")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_animal;
	private String nombre;
	private String raza;
	private String especie;
	private double edad;
	private String sexo;
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario")
	private Propietario propietario;


	public Animal() {}


	public Animal(int id_animal, String nombre, String raza, String especie, double edad, String sexo, String color, Propietario propietario) {
		this.id_animal = id_animal;
		this.nombre = nombre;
		this.raza = raza;
		this.especie = especie;
		this.edad = edad;
		this.sexo = sexo;
		this.color = color;
		this.propietario = propietario;
	}


	public int getId_animal() {
		return id_animal;
	}

	public void setId_animal(int id_animal) {
		this.id_animal = id_animal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
}