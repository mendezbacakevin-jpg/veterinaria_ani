package com.example.demo.service.interfaces;

import com.example.demo.dtos.cita.ListarVetDto;
import com.example.demo.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICitaService {
    public Animal guardarAnimal(Animal animal);
    public Cita guardarCita(Cita cita);
    public List<Cita> listarCitas();
    public List<ListarVetDto> listaVeterianarios();
    public List<Servicio> listarServicios();
    public Propietario guardarPropietario(Propietario pro);
    public Servicio buscarServicioPorId(int id);
    public Veterinario buscarVetPorId(int id);
    public DetalleCita guardarDetalle(DetalleCita detalleCita);
}
