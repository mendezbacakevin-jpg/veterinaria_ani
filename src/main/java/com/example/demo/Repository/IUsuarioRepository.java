package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Usuario;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Integer> {
	
	
	// Método que busca un usuario por su correo electrónico.
	// Se utiliza desde el Controller para obtener los datos del usuario.
	//COLOCAMOS ESTA BSQUEDA PARA QUE PUEDA TRAER EL DATOS QUE LE ESTAMOS PASANDO DESDE EL CONTROLLER
	Usuario findByEmail(String email);


}
