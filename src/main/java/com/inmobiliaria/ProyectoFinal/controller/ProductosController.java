package com.inmobiliaria.ProyectoFinal.controller;
import ch.qos.logback.core.model.Model;
import com.inmobiliaria.ProyectoFinal.service.*;
import com.inmobiliaria.ProyectoFinal.entity.*;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductosController{


    private final ProductosService productoService;
    @GetMapping("/")
    public String ListarProductos(Model model){
        List<Productos> productos= productoService.listarProductos();
        return " ";
    }


    public ProductosController(ProductosService service){
 this.productoService=service;
    }


    @PostMapping()
    public String MostrarPorProductoPorId(@RequestParam("id_producto") String id_producto, Model model){
        int id=Integer.parseInt(id_producto);

          Productos p=productoService.TraerProductoPorId(id);

        return "Redicet:/html/VerProducto";

    }


}