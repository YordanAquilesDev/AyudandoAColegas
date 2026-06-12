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
    private final DetalleOfertaService detalleOfertaService;

    public HomeController(ProductosService productoService, OfertasService ofertasService, DetalleOfertaService detalleOfertaService) {
        this.productoService = productoService;
        this.ofertasService = ofertasService;
        this.detalleOfertaService = detalleOfertaService;
    }
    @GetMapping("/")
    public String index(Model model) {
        try {
            // Prueba 1: Comenta las líneas de los servicios una por una para ver cuál falla
            model.addAttribute("ofertas", ofertasService.obtenerTodasLasOfertas());
            model.addAttribute("productos", productoService.listarProductos());
 String prueva;
            return "index";
        } catch (Exception e) {
            // Esto imprimirá el verdadero error limpio en tu consola de IntelliJ
            System.out.println(" EL ERROR REAL ES: " + e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }
}