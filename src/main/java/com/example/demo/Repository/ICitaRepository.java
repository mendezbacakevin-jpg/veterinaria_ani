package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.classes.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Integer> {

}
