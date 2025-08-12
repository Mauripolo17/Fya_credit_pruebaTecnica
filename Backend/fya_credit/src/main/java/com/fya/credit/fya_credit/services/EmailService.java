package com.fya.credit.fya_credit.services;

import com.fya.credit.fya_credit.models.CreditCreatedEvent;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class EmailService {


    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void enviarNotificacionCredito(CreditCreatedEvent evento) {
        try {
           SimpleMailMessage message = new SimpleMailMessage();

            message.setTo("mauriciopoloem@gmail.com");
            message.setSubject("Nuevo Crédito Registrado - " + evento.getNombreCliente());
            message.setText(construirContenidoEmail(evento));
            message.setFrom("mauripolo14@gmail.com");
            mailSender.send(message);

//            System.out.println("Email enviado exitosamente para crédito ID: " + evento.getCreditoId());
        } catch (Exception e) {
            System.err.println("Error enviando email: " + e.getMessage());
        }
    }

    private String construirContenidoEmail(CreditCreatedEvent evento) {

        return String.format("""
        ¡Hola!
        
        Espero que tengas un excelente día. Te escribo para informarte que se ha registrado 
        un nuevo crédito en nuestro sistema.
        
        %s ha solicitado un crédito por valor de $%,.2f. El comercial a cargo de esta 
        operación es %s, y el registro se realizó el %s.
        
        
        ¡Que tengas un gran día!
        
        ---
        Este es un mensaje automático del sistema de gestión de créditos.
        Por favor, no respondas a este correo.
        """,
                evento.getNombreCliente(),
                evento.getValorCredito(),
                evento.getNombreComercial(),
                evento.getFechaRegistro()
        );
    }
}

