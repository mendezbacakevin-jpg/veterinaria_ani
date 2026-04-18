package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.classes.DetalleCita;

public interface IDetalleRepository  extends JpaRepository<DetalleCita, Integer>  {

}
