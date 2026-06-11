package com.inmobiliaria.ProyectoFinal.controller;

@Controller
@RequestMapping("productos")
public class ProductosController{

    private final ProductoService productoService;

    public ProductosController(ProductoService service){
 this.productoService=service;
    }


    @PostMapping
    public String MostrarPorProductoPorId(@RequestParam("id_producto") String id_producto,Model model){



        return "Redicet:/html/VerProducto"

    }
}