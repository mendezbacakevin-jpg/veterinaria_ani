package com.example.demo.service.interfaces;

import jakarta.mail.MessagingException;

import java.util.Map;

public interface IEmailService {
    public void sendSimpleEmail(String toEmail, String subject, String body);
    public void sendWelcomeEmail(String toEmail, String username) throws MessagingException;
    public void enviarCorreoDeCompra(Map<String, Object> datos);

}
