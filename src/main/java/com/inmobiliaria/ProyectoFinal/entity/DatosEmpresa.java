package com.inmobiliaria.ProyectoFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="datos_empresa")
public class DatosEmpresa {
    @Id
    @Column(name="id_empresa")
    private int idEmpresa;
    private String nombreEmpresa;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String correo;
}
