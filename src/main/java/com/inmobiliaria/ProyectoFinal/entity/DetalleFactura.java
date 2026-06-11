package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="detalle_facturas")
public class DetalleFactura {
    @Id
    @Column(name="id_detalle_factura")
    private int idDetalleFactura;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_factura")
    private Factura factura;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="id_producto")
    private Productos productos;

    private int  cantidad;
}
