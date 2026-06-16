package com.inmobiliaria.ProyectoFinal.controller;

import com.inmobiliaria.ProyectoFinal.service.DetalleOfertaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.inmobiliaria.ProyectoFinal.service.ProductosService;
import com.inmobiliaria.ProyectoFinal.service.OfertasService;

import org.springframework.ui.Model;


@Controller
public class HomeController {

    // 1. Inyectamos ambos servicios en el Home
    private final ProductosService productoService;
    private final OfertasService ofertasService;

    public HomeController(ProductosService productoService, OfertasService ofertasService, DetalleOfertaService detalleOfertaService) {
        this.productoService = productoService;
        this.ofertasService = ofertasService;

    }

    @GetMapping("/")
    public String index(Model model) {
        try {
            model.addAttribute("ofertas", ofertasService.obtenerTodasLasOfertas());//-->lista de ofertas en la db
            model.addAttribute("productos", productoService.listarProductos());//---> lista de productos en la db

            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }




}