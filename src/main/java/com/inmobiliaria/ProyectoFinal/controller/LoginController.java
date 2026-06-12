package com.inmobiliaria.ProyectoFinal.controller;

import com.inmobiliaria.ProyectoFinal.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/iniciar_sesion")
public class LoginController{
   private  LoginService loginService;
   public LoginController(LoginService loginService){
       this.loginService=loginService;
   }

    @PostMapping("/autenticarse")
    public String iniciarSesion(@RequestParam("usuario") String user,
                              @RequestParam("password") String password)
    {
        System.out.println("estamos en autrendicarse");
        System.out.println("estamos en autrendicarse");
        System.out.println("estamos en autrendicarse");
        if(loginService.TienePermizo(user,password)){
            return "/html/Admind/Administrador";
        }else{
            return "redirect/html/Login";

        }

    
    }

    @GetMapping("/")
    public String irALogin(){
        System.out.println("Estamos en el metod de iniciar sesion");
        System.out.println("Estamos en el metod de iniciar sesion");
        System.out.println("Estamos en el metod de iniciar sesion");
        return "/html/Login";
    }
}