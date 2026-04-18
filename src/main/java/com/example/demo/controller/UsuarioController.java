package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Repository.IUsuarioRepository;
import com.example.demo.classes.Usuario;
import com.example.demo.classes.UsuarioService;
import com.example.demo.classes.correo.EmailService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/pago")
public class UsuarioController {

    // 🔹 ATRIBUTOS (AQUÍ VAN)
    private final UsuarioService usuarioService;

    @Autowired
    private IUsuarioRepository repoUsuario;

    @Autowired
    private EmailService emailService;

    // 🔹 CONSTRUCTOR (SOLO UNO)
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // 🔹 MOSTRAR LOGIN
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    // 🔹 MOSTRAR REGISTRO (opcional)
    @GetMapping("/registrarUsuario")
    public String mostrarRegistro() {
        return "login";
    }

    // 🔹 REGISTRAR USUARIO
    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@RequestParam String username,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   Model model) {

        Usuario nuevo = new Usuario();
        nuevo.setUsername(username);
        nuevo.setEmail(email);
        nuevo.setPassword(password);
        repoUsuario.save(nuevo);

        try {
            emailService.sendWelcomeEmail(email, username);
        } catch (MessagingException e) {
            model.addAttribute("mensaje", "Usuario registrado, pero falló el correo.");
            return "login";
        }

        model.addAttribute("mensaje", "Usuario registrado correctamente.");
        return "login";
    }

    // 🔹 LOGIN
    @PostMapping("/login")
    public String validarLogin(@RequestParam String email,
                               @RequestParam String password,
                               Model model,
                               HttpSession session) {

        Usuario usuario = repoUsuario.findByEmail(email);

        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "principal";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    // 🔹 LOGOUT
    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "principal";
    }

    // 🔹 PERFIL
    @GetMapping("/perfil")
    public String mostrarPerfil(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "principal";
        }

        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    // 🔹 ACTUALIZAR PERFIL
    @PostMapping("/actualizarPerfil")
    public String actualizarPerfil(@RequestParam String email,
                                   @RequestParam String password,
                                   HttpSession session,
                                   RedirectAttributes redirectAttributes) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario != null) {
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuarioService.actualizar(usuario);

            redirectAttributes.addFlashAttribute("mensaje", "Perfil actualizado correctamente.");
        }

        return "redirect:/perfil";
    }

    // 🔹 ENVIAR CORREO
    @PostMapping("/enviar-correo")
    public ResponseEntity<String> enviarCorreo(@RequestBody Map<String, Object> datos) {
        try {
            emailService.enviarCorreoDeCompra(datos);
            return ResponseEntity.ok("Correo enviado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar correo");
        }
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


