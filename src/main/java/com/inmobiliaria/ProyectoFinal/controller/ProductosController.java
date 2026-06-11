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

       Productos productoService.TraerProductoPorId(id_producto);

        return "Redicet:/html/VerProducto"

    }
}