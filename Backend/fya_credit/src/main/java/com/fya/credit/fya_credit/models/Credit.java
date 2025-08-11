package com.fya.credit.fya_credit.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "creditos")
@Data
@RequiredArgsConstructor
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreCliente;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tipoDocumento;

    @Column(nullable = false, unique = true, length = 20)
    private Long numeroDocumento;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal valorCredito;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @Column(nullable = false)
    private Integer plazoMeses;

    @Column (nullable = false)
    private String comercialQueRegistra;

    @Column(nullable = true)
    private String descripcion;


    @Column(nullable = false)
    private LocalDate fechaDeRegistro;


    public void setFechaDeRegistro(LocalDate fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
}
