package com.example.demo.mapper;

import com.example.demo.dtos.cita.ListarVetDto;
import com.example.demo.entity.Veterinario;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {
    public ListarVetDto toDtoListarVet(Veterinario entity) {
        ListarVetDto dto = new ListarVetDto();

        dto.setId_veterinario(entity.getId_veterinario());
        dto.setNombre(entity.getNombre());
        return dto;
    }



}
