package com.inmobiliaria.ProyectoFinal.controller;

@Controller
@RequestMapping("Ofertas")
public class OfertasController{

    public String ListarOfertas(Model model){
        return "redirect/html/Ofertas";
    }


    public String VerOferta(@RequestParam("id_oferta") String idOferta,Model model){
        return "Redicet:/html/VerOferta";

    }
    
}