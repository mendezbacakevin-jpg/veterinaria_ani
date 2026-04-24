package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Cita {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id_cita;
	    private Date fecha;
	    private LocalTime hora;
	    private String motivo;
	    private String observaciones;
	    private BigDecimal precio_cita;
	    private BigDecimal total;
	    private Date fecha_registro;

	 

	    // getter y setter para horaFormateada

	    
	    @ManyToOne
	    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal")
	    private Animal animal;

	    @ManyToOne
	    @JoinColumn(name = "id_veterinario", referencedColumnName = "id_veterinario", nullable = true)
	    private Veterinario veterinario;

	    @ManyToOne
	    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = true)
	    private EstadoCita estadoCita;
	   
	    
	    @ManyToOne
	    @JoinColumn(name = "id_servicio",  referencedColumnName = "id_servicio")
	    private Servicio servicio;

 
	    public Cita() {}



		public Cita(int id_cita, Date fecha, LocalTime hora, String motivo, String observaciones,
				BigDecimal precio_cita, BigDecimal total, Date fecha_registro, Animal animal, Veterinario veterinario,
				EstadoCita estadoCita, Servicio servicio) {
			super();
			this.id_cita = id_cita;
			this.fecha = fecha;
			this.hora = hora;
			this.motivo = motivo;
			this.observaciones = observaciones;
			this.precio_cita = precio_cita;
			this.total = total;
			this.fecha_registro = fecha_registro;
			this.animal = animal;
			this.veterinario = veterinario;
			this.estadoCita = estadoCita;
			this.servicio = servicio;
		}



		public int getId_cita() {
			return id_cita;
		}

		public void setId_cita(int id_cita) {
			this.id_cita = id_cita;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		

		public String getMotivo() {
			return motivo;
		}

		public void setMotivo(String motivo) {
			this.motivo = motivo;
		}

		public String getObservaciones() {
			return observaciones;
		}

		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}

		public BigDecimal getPrecio_cita() {
			return precio_cita;
		}

		public void setPrecio_cita(BigDecimal precio_cita) {
			this.precio_cita = precio_cita;
		}

		public BigDecimal getTotal() {
			return total;
		}

		public void setTotal(BigDecimal total) {
			this.total = total;
		}

		public Date getFecha_registro() {
			return fecha_registro;
		}

		public void setFecha_registro(Date fecha_registro) {
			this.fecha_registro = fecha_registro;
		}

		public Animal getAnimal() {
			return animal;
		}

		public void setAnimal(Animal animal) {
			this.animal = animal;
		}

		public Veterinario getVeterinario() {
			return veterinario;
		}

		public void setVeterinario(Veterinario veterinario) {
			this.veterinario = veterinario;
		}

		public EstadoCita getEstadoCita() {
			return estadoCita;
		}

		public void setEstadoCita(EstadoCita estadoCita) {
			this.estadoCita = estadoCita;
		}

		public Servicio getServicio() {
			return servicio;
		}

		public void setServicio(Servicio servicio) {
			this.servicio = servicio;
		}



		public LocalTime getHora() {
			return hora;
		}



		public void setHora(LocalTime hora) {
			this.hora = hora;
		}


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
