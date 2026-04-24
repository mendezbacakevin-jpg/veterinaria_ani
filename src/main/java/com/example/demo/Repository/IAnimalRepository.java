package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Animal;

public interface IAnimalRepository extends JpaRepository<Animal, Integer> {

}
