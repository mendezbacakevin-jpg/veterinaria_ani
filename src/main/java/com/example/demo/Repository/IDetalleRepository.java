package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DetalleCita;

public interface IDetalleRepository  extends JpaRepository<DetalleCita, Integer>  {

}
