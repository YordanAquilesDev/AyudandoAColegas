package com.inmobiliaria.ProyectoFinal.controller;

@Controller
@RequestMapping("Ofertas")
public class OfertasController{

    @GetMapping("/listar")
    public String ListarOfertas(Model){
        return "redirect/html/Ofertas";
    }


   @GetMapping("/mostrar_oferta")
    public String VerOferta(@RequestParam("id_oferta") String idOferta,Model model){
        return "Redicet:/html/VerOferta"

    }

    @PostMapping("/GuardarOferta")
    public String GuardarOferta(){

    }

    @PostMapping("/comprar/{id}")
    public String  comprarOgerta(){

    }
    
}