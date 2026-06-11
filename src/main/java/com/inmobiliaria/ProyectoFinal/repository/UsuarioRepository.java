package com.inmobiliaria.ProyectoFinal.repository;

import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inmobiliaria.ProyectoFinal.entity.*;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.password = ?2")
    Optional<Usuario> autenticarUsuario(String usuario, String password);

}