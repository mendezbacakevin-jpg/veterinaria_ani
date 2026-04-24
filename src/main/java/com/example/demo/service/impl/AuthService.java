package com.example.demo.service.impl;

import com.example.demo.Repository.IUsuarioRepository;
import com.example.demo.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUsuarioRepository repoUsuario;

    @Override
    public void validarUsuario(String email,String password) {

    }
}
