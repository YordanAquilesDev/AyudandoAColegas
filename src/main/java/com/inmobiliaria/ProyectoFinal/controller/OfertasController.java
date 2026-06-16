package com.inmobiliaria.ProyectoFinal.controller;

import ch.qos.logback.core.model.Model;
import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.service.OfertasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("Ofertas")
public class OfertasController{
    private OfertasService ofertasService;

    @GetMapping
    public String ListarOfertasIndex(Model model){
        List<Ofertas> ofertas=ofertasService.obtenerTodasLasOfertas();
        return "index";
    }


    public String ListarOfertas(Model model){
        return "redirect/html/Ofertas";
    }


   @GetMapping("/mostrar_oferta")
    public String VerOferta(@RequestParam("id_oferta") String idOferta, Model model){
        return "Redicet:/html/VerOferta";

    }


    @PostMapping("/comprar/{id}")
    public String  comprarOgerta(){
 return "redirect/html/comprarOgerta";
    }

}