package com.fya.credit.fya_credit.controller.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record CreditDto(

        Long id,

        @NotBlank(message = "El nombre del cliente es obligatorio")
        @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
        String nombreCliente,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "El tipo de documento es obligatorio")
        String tipoDocumento,

        @NotNull(message = "El número de documento es obligatorio")
        Long numeroDocumento,

        @NotNull(message = "El valor del crédito es obligatorio")
        @DecimalMin(value = "0.01", message = "El valor debe ser mayor a 0")
        BigDecimal valorCredito,

        @NotNull(message = "La tasa de interés es obligatoria")
        @DecimalMin(value = "0.01", message = "La tasa debe ser mayor a 0")
        @DecimalMax(value = "100.00", message = "La tasa no puede exceder 100%")
        BigDecimal tasaInteres,

        @NotNull(message = "El plazo es obligatorio")
        @Min(value = 1, message = "El plazo mínimo es 1 mes")
        @Max(value = 60, message = "El plazo máximo es 60 meses")
        Integer plazoMeses,

        @NotBlank(message = "El comercial es obligatorio")
        String comercial,

        String proposito,
        LocalDate fechaDeRegistro
) {}



