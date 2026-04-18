package com.example.demo.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "propietarios")
public class Propietario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_propietario;
	private String codigo ;
	private String nombre;
	private String telefono;
	private String gmail;
	
	
	public Propietario () {}


	public Propietario(int id_propietario, String codigo, String nombre, String telefono, String gmail) {
		super();
		this.id_propietario = id_propietario;
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.gmail = gmail;
	}


	public int getId_propietario() {
		return id_propietario;
	}


	public void setId_propietario(int id_propietario) {
		this.id_propietario = id_propietario;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
	
	

}
