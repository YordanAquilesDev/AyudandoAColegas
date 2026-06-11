package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ofertas")
public class Ofertas {
    @Id
    @Column(name="id_oferta")
    private int idOferta;

    @Column(name="precio_oferta")
    private double precioOferta;

}
