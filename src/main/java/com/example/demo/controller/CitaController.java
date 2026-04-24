package com.example.demo.controller;

import com.example.demo.dtos.cita.ListarVetDto;
import com.example.demo.entity.*;
import com.example.demo.service.interfaces.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/cita")
public class CitaController {
    @Autowired
    private ICitaService citaService;

    //lista las citas Registradas

    @GetMapping("/citas")
    public String listarCitas(Model model) {
        List<Cita> citas = citaService.listarCitas();

        // No formateamos ni enviamos la hora, porque no la usaremos en la vista

        model.addAttribute("citas", citas);
        return "listarRegistro"; // El nombre de tu plantilla Thymeleaf
    }


    //LISTAR LOS REGISTROS DE LA PERSONA
    // EN LA PRINCIPAL

    @GetMapping("/listarRegistro")
    public String listarRegistros(Model model) {
        // Aquí agregar lógica para llenar el modelo si es necesario
        return "listarRegistro"; // Asegúrate de tener listarRegistro.html o .jsp en templates
    }

    @PostMapping("/grabar")
    public String grabar(@ModelAttribute Cita cita, @RequestParam("veterinarioId") int veterinarioId, @RequestParam("id_servicio") int idServicio,
                         Model model) {
        try {
            // Precio base fijo
            BigDecimal precioCita = new BigDecimal("50.00");
            cita.setPrecio_cita(precioCita);

            // 1. Guardar Propietario si es nuevo
            Animal animal = cita.getAnimal();
            if (animal == null) {
                model.addAttribute("mensaje", "El animal es obligatorio");
                model.addAttribute("cssmensaje", "alert alert-danger");
                model.addAttribute("cita", cita);
                model.addAttribute("veterinarios", citaService.listaVeterianarios());
                model.addAttribute("ltsServicios", citaService.listaVeterianarios());
                return "prueba";
            }
            Propietario propietario = animal.getPropietario();
            if (propietario != null) {
                // Si el propietario no tiene id asignado (nuevo), guardarlo
                if (propietario.getId_propietario() == 0) {
                    propietario = citaService.guardarPropietario(propietario);
                }
                animal.setPropietario(propietario);
            } else {
                model.addAttribute("mensaje", "El propietario es obligatorio");
                model.addAttribute("cssmensaje", "alert alert-danger");
                model.addAttribute("cita", cita);
                model.addAttribute("veterinarios", citaService.listaVeterianarios());
                model.addAttribute("ltsServicios", citaService.listarServicios());
                return "prueba";
            }

            // 2. Guardar Animal si es nuevo
            if (animal.getId_animal() == 0) {
                animal = citaService.guardarAnimal(animal);
            }
            cita.setAnimal(animal);

            // 3. Asignar Veterinario
            Veterinario vet = citaService.buscarVetPorId(veterinarioId);
            if (vet == null) {
                model.addAttribute("mensaje", "Veterinario no encontrado");
                model.addAttribute("cssmensaje", "alert alert-danger");
                model.addAttribute("cita", cita);
                model.addAttribute("veterinarios", citaService.listaVeterianarios());
                model.addAttribute("ltsServicios", citaService.listarServicios());
                return "prueba";
            }
            cita.setVeterinario(vet);

            // 4. Asignar Servicio
            Servicio servicio = citaService.buscarServicioPorId(idServicio);
            if (servicio == null) {
                model.addAttribute("mensaje", "Servicio no encontrado");
                model.addAttribute("cssmensaje", "alert alert-danger");
                model.addAttribute("cita", cita);
                model.addAttribute("veterinarios", citaService.listaVeterianarios());
                model.addAttribute("ltsServicios", citaService.listarServicios());
                return "prueba";
            }
            cita.setServicio(servicio);

            // 5. Guardar la Cita (ahora que ya todos los objetos referenciados están persistidos o componentes ya persistidos)
            Cita citaGuardada = citaService.guardarCita(cita);

            // 6. Crear y guardar el detalle de la cita
            DetalleCita detalle = new DetalleCita();
            detalle.setCita(citaGuardada);
            detalle.setServicio(servicio);
            detalle.setPrecio_servicio(servicio.getPrecio());
            citaService.guardarDetalle(detalle);

            // 7. Calcular total y actualizar la cita
            BigDecimal total = precioCita.add(servicio.getPrecio());
            citaGuardada.setTotal(total);
            citaService.guardarCita(cita);

            model.addAttribute("mensaje", "Registro OK");
            model.addAttribute("cssmensaje", "alert alert-success");

        } catch (Exception e) {
            model.addAttribute("mensaje", "Error al registrar: " + e.getMessage());
            model.addAttribute("cssmensaje", "alert alert-danger");
        }

        // Para preparar formulario limpio
        model.addAttribute("cita", new Cita());
        model.addAttribute("veterinarios", citaService.listaVeterianarios());
        model.addAttribute("ltsServicios", citaService.listarServicios());
        return "prueba";
    }


    @GetMapping("/cargar")
    public String cargarPaginaRegistrar(Model model) {
        Cita cita = new Cita();
        cita.setAnimal(new Animal());
        cita.getAnimal().setPropietario(new Propietario());
        cita.setPrecio_cita(new BigDecimal("50.00"));

        model.addAttribute("cita", cita);

        // Obtener todos los servicios
        List<Servicio> listaServicios = citaService.listarServicios();
        System.out.println("Servicios encontrados: " + listaServicios.size()); // 🔍 Debug
        model.addAttribute("servicios", listaServicios);

        // Veterinarios
        List<ListarVetDto> listaVeterinarios = citaService.listaVeterianarios();
        model.addAttribute("veterinarios", listaVeterinarios);

        return "prueba";  // nombre de la plantilla Thymeleaf
    }








    @GetMapping("/form-cita")
    public String mostrarFormulario(Model model) {
        Cita cita = new Cita();
        BigDecimal precioCita = new BigDecimal("50.00");
        cita.setPrecio_cita(precioCita);
        cita.setTotal(precioCita);  // inicial total = precio cita sin servicios
        cita.setVeterinario(null);
        model.addAttribute("cita", cita);
        model.addAttribute("ltsServicios", citaService.listarServicios());  // servicios con id y precio

        return "form-cita";
    }





    @GetMapping("/servicio/precio/{id}")
    @ResponseBody
    public BigDecimal obtenerPrecioServicio(@PathVariable("id") int idServicio) {
        Servicio servicio = citaService.buscarServicioPorId(idServicio);
        if (servicio != null) {
            return servicio.getPrecio();
        }
        return BigDecimal.ZERO;
    }


}
