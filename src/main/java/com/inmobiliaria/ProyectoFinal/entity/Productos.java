package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Productos {
    @Id
    @Column(name="id_producto")
    private int idProducto;
    private String descripcion;

    private double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @Column(name="imagen_referencia")
    private String imagenReferencia;
}
