package com.example.demo.controller;


import com.example.demo.entity.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VeterinariaController {

	@GetMapping("/principal")
	public String mostrarPrincipal() {
	    return "principal"; // nombre de la plantilla en src/main/resources/templates/principal.html
	}

	
	
	@GetMapping("/nosotros")
	public String mostrarsubpagina() {
	    return "nosotros"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	@GetMapping("/servicio")
	public String mostrarservicio() {
	    return "servicio"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	@GetMapping("/equipo")
	public String mostrarequipo() {
	    return "equipo"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	@GetMapping("/contacto")
	public String mostrarContacto() {
	    return "contacto"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	@GetMapping("/medicinageneral")
	public String mostrarmedicinageneral() {
	    return "medicinageneral"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	
	@GetMapping("/cirugiasespecializados")
	public String mostrarcirugiasespecializados() {
	    return "cirugiasespecializados"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	
	@GetMapping("/laboratorio")
	public String mostrarlaboratorio() {
	    return "laboratorio"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	
	@GetMapping("/peluqueria")
	public String mostrarpeluqueria() {
	    return "peluqueria"; // Thymeleaf buscará templates/nosotros.html
	}

	
	@GetMapping("/vacunacion")
	public String mostrarvacunacion() {
	    return "vacunacion"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	
	@GetMapping("/guarderia")
	public String mostrarguarderia() {
	    return "guarderia"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	
	@GetMapping("/login")
	public String login() {
	    return "login"; // Thymeleaf buscará templates/nosotros.html
	}

	
	
	/*ALIMENTOS*/
	
	@GetMapping("/alimentoperro")
	public String alimentoperro() {
	    return "alimentoperro"; // Thymeleaf buscará templates/alimentoperro.html
	}

	
	
	@GetMapping("/alimentogato")
	public String alimentogato() {
	    return "alimentogato"; // Thymeleaf buscará templates/alimentoperro.html
	}

	
	//JUGUETES

	@GetMapping("/jugueteperro")
	public String jugueteperro() {
	    return "jugueteperro"; // Thymeleaf buscará templates/alimentoperro.html
	}

	
	
	@GetMapping("/juguetegato")
	public String juguetegato() {
	    return "juguetegato"; // Thymeleaf buscará templates/alimentoperro.html
	}

	
	
	//ACCESORIOS

	@GetMapping("/accesoriosperro")
	public String accesoriosperro() {
	    return "accesoriosperro"; // Thymeleaf buscará templates/alimentoperro.html
	}

	@GetMapping("/accesoriosgato")
	public String accesoriosgato() {
	    return "accesoriosgato"; // Thymeleaf buscará templates/alimentoperro.html
	}

	@GetMapping("/carrocompras")
	public String carrocompras() {
	    return "carrocompras"; // Thymeleaf buscará templates/alimentoperro.html
	}


	//DEBEMOS TENER CLASE CITA YA QUE NECESITA ESE PARAMETRO POR LA BASE DE DATOS
	@GetMapping("/prueba")
	public String mostrarprueba(Model model) {
		model.addAttribute("cita", new Cita());  // Crear un objeto vacío para el formulario
		return "prueba";
	}




}
