package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EstadoCita;

public interface IEstadoCitaRepository  extends JpaRepository<EstadoCita, Integer>  {
  
}
