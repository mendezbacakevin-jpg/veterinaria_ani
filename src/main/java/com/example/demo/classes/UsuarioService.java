package com.example.demo.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.IUsuarioRepository;



//Actúa como intermediario entre el controlador y la base de datos.
//para poder guardar cambios que hagamos 



@Service
public class UsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public void actualizar(Usuario usuario) {
        usuarioRepository.save(usuario); // Actualiza en base de datos
    }
    
    
    
    
}
