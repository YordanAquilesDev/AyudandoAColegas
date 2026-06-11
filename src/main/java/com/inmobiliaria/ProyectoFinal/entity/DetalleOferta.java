package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="detalle_oferta")
public class DetalleOferta {
    @Id
    private int idDetalleOferta;

    @ManyToOne
    @JoinColumn(name = "id_oferta")
    private Ofertas oferta; // Objeto único, NO lista


    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;

    private int cantidad;

}
