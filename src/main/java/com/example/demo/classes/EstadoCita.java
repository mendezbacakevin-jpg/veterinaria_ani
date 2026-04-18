package com.example.demo.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadocitas")
public class EstadoCita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;
    private String nombre_estado;

    public EstadoCita() {}

	public EstadoCita(int id_estado, String nombre_estado) {
		super();
		this.id_estado = id_estado;
		this.nombre_estado = nombre_estado;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	
	
	
	
	
	

}
