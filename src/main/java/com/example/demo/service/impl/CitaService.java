package com.example.demo.service.impl;

import com.example.demo.Repository.*;
import com.example.demo.dtos.cita.ListarVetDto;
import com.example.demo.entity.*;
import com.example.demo.mapper.CitaMapper;
import com.example.demo.service.interfaces.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService implements ICitaService {
    @Autowired
    private IAnimalRepository repoAnimal;

    @Autowired
    private ICitaRepository repoCita;

    @Autowired
    private IDetalleRepository repoDetalle;

    @Autowired
    private IEstadoCitaRepository repoEstadoCita;

    @Autowired
    private IPropietarioRepository repoPropietario;

    @Autowired
    private IServicioRepository repoServicio;


    @Autowired
    private IVeterinarioRepository repoVeterinario;

    @Autowired
    private CitaMapper mapper;


    @Override
    public Animal guardarAnimal(Animal animal) {
        repoAnimal.save(animal);
        return animal;
    }

    @Override
    public Cita guardarCita(Cita cita) {
        repoCita.save(cita);
        return cita;
    }

    @Override
    public List<Cita> listarCitas() {
        return repoCita.findAll();
    }

    @Override
    public List<ListarVetDto> listaVeterianarios() {
        return repoVeterinario.findAll()
                .stream()
                .map(mapper::toDtoListarVet)
                .toList();
    }

    @Override
    public List<Servicio> listarServicios() {
        return repoServicio.findAll();
    }

    @Override
    public Propietario guardarPropietario(Propietario pro) {
        repoPropietario.save(pro);
        return pro;
    }

    @Override
    public Servicio buscarServicioPorId(int id) {
        return repoServicio.findById(id).orElse(null);
    }

    @Override
    public Veterinario buscarVetPorId(int id) {
        return repoVeterinario.findById(id).orElse(null);
    }

    @Override
    public DetalleCita guardarDetalle(DetalleCita detalleCita) {
        repoDetalle.save(detalleCita);
        return detalleCita;
    }
}
