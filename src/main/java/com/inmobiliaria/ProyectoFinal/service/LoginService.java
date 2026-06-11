package com.inmobiliaria.ProyectoFinal.service;
@Service
public class LoginSevice{
    private final UsuarioRepository usuario;

    public Loginservice(UsuarioRepository usuario){
        this.usuario=usuario;
    }


    public boolean TienePermizo(String user, String pasword){
        if(user.isEmpty()|| password.isEmpty()){
            thowr new IlegalException("Los valores  de user y pasword deven tener valores")
        }
        if(usuario.autenticarUsuario(user,password)==null){

            return false

        } else{
            return true;}
        

    }


}