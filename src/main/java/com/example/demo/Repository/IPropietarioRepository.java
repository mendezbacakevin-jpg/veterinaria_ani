package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Propietario;

public interface IPropietarioRepository extends JpaRepository<Propietario, Integer>  {

}
