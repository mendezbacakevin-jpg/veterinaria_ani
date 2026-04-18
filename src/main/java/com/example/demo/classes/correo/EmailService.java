package com.example.demo.classes.correo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Mendezbacakevin@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
    
    
    
    
 // Método para enviar correo HTML de bienvenida
    public void sendWelcomeEmail(String toEmail, String username) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("Mendezbacakevin@gmail.com");
        helper.setTo(toEmail);
        helper.setSubject("🎉 Bienvenido a Clínica Vida Animal, " + username + "!");

        String htmlMsg = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                "  .container { font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5; }" +
                "  .header { background-color: #7494ec; color: white; padding: 10px; text-align: center; border-radius: 8px; }" +
                "  .content { margin-top: 20px; }" +
                "  .footer { margin-top: 30px; font-size: 12px; color: #555; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='header'><h2>Bienvenido a Clínica Vida Animal</h2></div>" +
                "<div class='content'>" +
                "<p>Hola <strong>" + username + "</strong>,</p>" +
                "<p>¡Nos alegra que te hayas unido a nuestra comunidad de amantes de los animales!</p>" +
                "<p>Desde hoy tendrás acceso a:</p>" +
                "<ul>" +
                "<li>Reservar citas con nuestros especialistas</li>" +
                "<li>Recibir recomendaciones para el cuidado de tus mascotas</li>" +
                "<li>Poder hacer compras para tus animeles.</li>" +
                "<li>Promociones exclusivas y mucho más</li>" +
                "</ul>" +
                "<p>Estamos aquí para ayudarte a mantener a tus peluditos felices y saludables 🐾</p>" +
                "<p>¡Gracias por confiar en nosotros!</p>" +
                "</div>" +
                "<div class='footer'>Clínica Veterinaria Vida Animal | contacto@vidaanimal.com</div>" +
                "</div>" +
                "</body>" +
                "</html>";

        helper.setText(htmlMsg, true); // true = HTML

        mailSender.send(message);
    }
    
    
    
    
    
    
    private final String correoAdmin = "georghisanchezabanto@gmail.com"; // Cambia por tu correo


    //RECIBIMOS DATOS DEL CLIENTE
public void enviarCorreoDeCompra(Map<String, Object> datos) {
    try {
        String nombre = (String) datos.get("nombre");
        String emailCliente = (String) datos.get("email");
        String direccion = (String) datos.get("direccion");
        String telefono = (String) datos.get("telefono");
        String tipoTarjeta = (String) datos.get("tipo");

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> carrito = (List<Map<String, Object>>) datos.get("carrito");

        double total = 0;
        StringBuilder productosHtml = new StringBuilder();
        for (Map<String, Object> item : carrito) {
            String producto = (String) item.get("nombre");
            double precio = Double.parseDouble(item.get("precio").toString());
            int cantidad = Integer.parseInt(item.get("cantidad").toString());
            double subtotal = precio * cantidad;
            total += subtotal;

            productosHtml.append("<tr>")
                    .append("<td style='padding: 10px; border-bottom: 1px solid #ddd;'>").append(producto).append("</td>")
                    .append("<td style='padding: 10px; border-bottom: 1px solid #ddd; text-align:center;'>").append(cantidad).append("</td>")
                    .append("<td style='padding: 10px; border-bottom: 1px solid #ddd; text-align:right;'>S/ ").append(String.format("%.2f", precio)).append("</td>")
                    .append("<td style='padding: 10px; border-bottom: 1px solid #ddd; text-align:right;'>S/ ").append(String.format("%.2f", subtotal)).append("</td>")
                    .append("</tr>");
        }

        String contenidoHtml = "<!DOCTYPE html>"
                + "<html lang='es'>"
                + "<head><meta charset='UTF-8'></head>"
                + "<body style='margin:0; padding:0; font-family: Arial, sans-serif; background-color:#f6f6f6;'>"
                + "<table align='center' width='600' cellpadding='0' cellspacing='0' style='background-color:#ffffff; margin-top:20px; border-radius:10px; overflow:hidden;'>"
                
                // HEADER
                + "<tr><td style='background-color:#007bff; color:white; padding:20px; text-align:center;'>"
                + "<h1>Clínica Vida Animal 🐾</h1>"
                + "<p>Gracias por tu compra, " + nombre + "!</p>"
                + "</td></tr>"
                
                // CUERPO
                + "<tr><td style='padding:20px;'>"
                + "<p>Aquí están los detalles de tu pedido:</p>"
                
                + "<table width='100%' cellpadding='0' cellspacing='0' style='border-collapse:collapse;'>"
                + "<thead>"
                + "<tr style='background-color:#f2f2f2;'>"
                + "<th style='padding:10px; text-align:left;'>Producto</th>"
                + "<th style='padding:10px; text-align:center;'>Cantidad</th>"
                + "<th style='padding:10px; text-align:right;'>Precio</th>"
                + "<th style='padding:10px; text-align:right;'>Subtotal</th>"
                + "</tr>"
                + "</thead>"
                + "<tbody>"
                + productosHtml
                + "</tbody>"
                + "</table>"
                
                + "<p style='text-align:right; font-size:18px; font-weight:bold;'>Total: S/ " + String.format("%.2f", total) + "</p>"
                
                + "<h3>Datos de entrega</h3>"
                + "<p>Dirección: " + direccion + "<br>"
                + "Teléfono: " + telefono + "<br>"
                + "Método de pago: " + tipoTarjeta + "</p>"
                
                // BOTÓN ESTILO TIENDA
               
                
                + "<p>¡Esperamos verte pronto! 🐶🐱</p>"
                + "</td></tr>"
                
                // FOOTER
                + "<tr><td style='background-color:#f2f2f2; color:#555; text-align:center; padding:15px;'>"
                + "Clínica Vida Animal &copy; 2025"
                + "</td></tr>"
                
                + "</table>"
                + "</body></html>";
        
        
//MIMEMESSAGE ES UN METODO PARA PODER ENVIAR CORREOS
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");
        helper.setTo(emailCliente);
        helper.setSubject("Confirmación de tu compra - Clínica Vida Animal");
        helper.setText(contenidoHtml, true);

        mailSender.send(mensaje);
        System.out.println("Correo estilo tienda enviado correctamente a " + emailCliente);

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error al enviar correo: " + e.getMessage());
    }
}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

