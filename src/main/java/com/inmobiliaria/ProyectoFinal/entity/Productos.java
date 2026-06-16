package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="productos")
@Setter
@Getter
public class Productos {
    @Id
    @Column(name="id_producto")
    private int idProducto;



    private String descripcion;

    @Column(name = "precio", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal precio;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @Column(name="imagen_referencia")
    private String imagenReferencia;

    private int cantidad;

}
