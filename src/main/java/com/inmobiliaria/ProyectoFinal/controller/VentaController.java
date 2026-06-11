package com.inmobiliaria.ProyectoFinal.controller;

public class VentaController {

    private ProductoService productosServce;
     static List<Productos> productos= new ArrayList<>();

    @PostMapping 
    public String registrarVenta(@RequestParam("id_producto") int idProducto){

    }

    @PostMapping
    public String registrarVenta(@RequestParam("id_oferta") int idOferta){

    }

    @PostMapping
    public String guardarEnelCarrito(@RequestParam("id_producto") String id_producto){

        Productos p=productosService.traerPorId(id_producto)

        productos.add()

    }

    @PostMapping()
    public Sring procesarVenta(){

    }
}
