package com.inmobiliaria.ProyectoFinal.service;

public interface UsuarioRepository extends JpaRepository<Usuario,interger>{

    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.password = ?2")
    Optional<Usuario> autenticarUsuario(String usuario, String password);

}