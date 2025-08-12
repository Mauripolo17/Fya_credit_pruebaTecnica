package com.fya.credit.fya_credit.services;

import com.fya.credit.fya_credit.models.CreditCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void handleCreditoCreated(CreditCreatedEvent event) {
        try {
            emailService.enviarNotificacionCredito(event);
        } catch (Exception e) {
            System.err.println("Error enviando email: " + e.getMessage());
        }
    }
}
