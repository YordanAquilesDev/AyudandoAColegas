package com.inmobiliaria.ProyectoFinal.repository;

import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.service.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.inmobiliaria.ProyectoFinal.entity.*;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query("SELECT u FROM Usuario u WHERE u.user_name = ?1 AND u.password_user = ?2")
    Optional<Usuario> autenticarUsuario(String usuario, String password);

}