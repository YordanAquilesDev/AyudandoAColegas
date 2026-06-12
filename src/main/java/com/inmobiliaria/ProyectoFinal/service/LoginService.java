package com.inmobiliaria.ProyectoFinal.service;
import org.springframework.stereotype.Service;
import com.inmobiliaria.ProyectoFinal.repository.UsuarioRepository;
@Service
public class LoginService {


    private  UsuarioRepository usuario;

    public LoginService(UsuarioRepository usuario){
        this.usuario=usuario;
    }


    public boolean TienePermizo(String user, String password){
        if(user.isEmpty()|| password.isEmpty()){
            throw new IllegalArgumentException("Los valores  de user y pasword deven tener valores");
        }
        if(usuario.autenticarUsuario(user, password).isEmpty()){

            return false;

        } else{
            return true;}
        

    }


}