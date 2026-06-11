package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categorias")
@Getter
@Setter
public class Categoria {

    @Id
    @Column(name="id_categoria")
    private int idCategoria;

    private String nombreCategoria;


}
