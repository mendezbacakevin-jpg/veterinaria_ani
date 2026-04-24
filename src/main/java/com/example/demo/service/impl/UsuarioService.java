package com.example.demo.service.impl;

import com.example.demo.entity.Usuario;
import com.example.demo.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.IUsuarioRepository;



//Actúa como intermediario entre el controlador y la base de datos.
//para poder guardar cambios que hagamos 



@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void actualizar(Usuario usuario) {
        usuarioRepository.save(usuario); // Actualiza en base de datos
    }

    public void actualizarPerfil(Usuario usuario,String email,String password){
        Usuario buscado =  usuarioRepository.findById(usuario.getId()).orElse(null);

        if(buscado != null){
            buscado.setEmail(email);
            buscado.setPassword(password);

            usuarioRepository.save(buscado);
        }
    }


    @Override
    public Usuario buscarPorEmaail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
