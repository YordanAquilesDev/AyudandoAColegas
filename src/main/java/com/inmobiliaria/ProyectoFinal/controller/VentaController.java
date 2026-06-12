package com.inmobiliaria.ProyectoFinal.controller;

import com.inmobiliaria.ProyectoFinal.entity.Productos;
import com.inmobiliaria.ProyectoFinal.service.OfertasService;
import com.inmobiliaria.ProyectoFinal.service.VentaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.inmobiliaria.ProyectoFinal.service.ProductosService;

import java.util.ArrayList;
import java.util.List;

public class VentaController {
     private OfertasService ofertasService;
     private ProductosService productosService;
     static List<Productos> productos= new ArrayList<>();
     private VentaService ventaService;

    @PostMapping("/registrar/producto")
    public String registrarVentaProducto(@RequestParam("id_producto") int idProducto
                                        ){
        String tipo="productos";
        boolean exito=ventaService.RegistrarVenta(productos,tipo);
        if(exito){
            return "redirect:/";
        }
        return "redirect:/";


    }

    @PostMapping("/registrar/Venta/oferta")
    public String registrarVentaOferta(@RequestParam("id_oferta") int idOferta){

        boolean exito=ventaService.RegistrarVenta(idOferta);
        if(exito){
            return "redirect:/";
        }
        return "redirect:/";



    }

    @PostMapping
    public String guardarEnelCarrito(@RequestParam("id_producto") String id_producto){
        int idProducto=Integer.parseInt(id_producto);

        Productos p=productosService.TraerProductoPorId(idProducto);

        productos.add(p);
        return "";

    }


}
