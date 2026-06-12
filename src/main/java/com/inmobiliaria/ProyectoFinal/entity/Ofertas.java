package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="ofertas")
@Setter
@Getter
public class Ofertas {
    @Id
    @Column(name="id_oferta")
    private int idOferta;

    @Column(name = "precio_oferta", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal precioOferta;

    @OneToMany(mappedBy = "oferta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DetalleOferta> detalles;



}
