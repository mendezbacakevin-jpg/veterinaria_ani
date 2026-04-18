package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.classes.Animal;

public interface IAnimalRepository extends JpaRepository<Animal, Integer> {

}
