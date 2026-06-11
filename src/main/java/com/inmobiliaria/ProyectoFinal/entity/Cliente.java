package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @Column(name="id_cliente")
    private int idCliente;

    private String nombre;

    private String dni;

}
