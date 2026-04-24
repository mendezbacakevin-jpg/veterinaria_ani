package com.example.demo.service.interfaces;

import com.example.demo.entity.Usuario;

public interface IUsuarioService {
    public void actualizar(Usuario reg);
    public Usuario buscarPorEmaail(String email);
    public void actualizarPerfil(Usuario usuario,String email,String password);
}
