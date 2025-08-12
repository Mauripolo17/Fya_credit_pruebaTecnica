package com.fya.credit.fya_credit.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class CreditCreatedEvent {

//    private final Long creditoId;
    private final String nombreCliente;
    private final BigDecimal valorCredito;
    private final String nombreComercial;
    private final LocalDate fechaRegistro;
}
