package com.inmobiliaria.ProyectoFinal.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="usuarios")
public class Usuario{
    @Id
    private int id_usuario ;
   private String user_name;
   private String password_user;
}