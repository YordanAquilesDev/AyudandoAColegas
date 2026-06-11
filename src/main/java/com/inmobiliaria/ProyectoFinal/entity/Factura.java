package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="factura")
public class Factura {
    @Id
    @Column(name="id_factura")
    private int idFactura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    @Column(name = "monto")
    private BigDecimal monto;
    private Date fecha;
    private String MetodoPago;
}
