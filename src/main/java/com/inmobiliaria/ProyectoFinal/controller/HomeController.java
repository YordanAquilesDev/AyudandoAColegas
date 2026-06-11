package com.inmobiliaria.ProyectoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    /**
     * al iniciar el main arranca en la base del puerto
     * localhost:8080/
     * como esta clase representa esa base o al iniciar 
     * encuntra esta clase y el metodo GET
     * lo redirige al index.html
     */
    
    //aca inicia el sping boot

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
