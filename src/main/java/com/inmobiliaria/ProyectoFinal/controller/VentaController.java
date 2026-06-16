package com.inmobiliaria.ProyectoFinal.controller;

import com.inmobiliaria.ProyectoFinal.entity.DatosEmpresa;
import com.inmobiliaria.ProyectoFinal.entity.DetalleOferta;
import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.entity.Productos;
import com.inmobiliaria.ProyectoFinal.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VentaController {

     private OfertasService ofertasService;
     private ProductosService productosService;
     private final DatosEmpresaService datosEmpresaService;
     private DetalleOfertaService detalleOfertaService;
     static List<Productos> productos= new ArrayList<>();
     private final VentaService ventaService;

     public VentaController(ProductosService productosService, VentaService ventaService, OfertasService ofertasService, DatosEmpresaService datosEmpresaService, DetalleOfertaService detalleOfertaService) {
         this.ofertasService = ofertasService;
         this.productosService= productosService;
         this.ventaService=ventaService;
         this.datosEmpresaService = datosEmpresaService;
         this.detalleOfertaService = detalleOfertaService;
     }



    @PostMapping("/registrar/producto")
    public String registrarVentaProducto(@RequestParam("id_producto") int idProducto
                                        ){
        String tipo="productos";
        boolean exito=ventaService.RegistrarVenta(productos);
        if(exito){
            return "redirect:/";
        }
        return "redirect:/";


    }

    @PostMapping("/comprarOferta")
    public String registrarVentaOferta(@RequestParam("id_oferta") int idOferta,Model model){

        boolean exito=ventaService.RegistrarVenta(idOferta);

        if(exito){
            Ofertas ofe= ofertasService.obtenerOfertaPorId(idOferta);
            DatosEmpresa datos= datosEmpresaService.traerDatosEmpresa();
            model.addAttribute("producto",ofe);
            model.addAttribute("ofertas",datos);
            return "/html/Factura";
        }
        return "index";

    }

 // Asegúrate de importar esto

    @GetMapping("/agregar/carrito")
    public String guardarEnelCarrito(@RequestParam("id") String id_producto, RedirectAttributes redirectAttributes) {
        int idProducto = Integer.parseInt(id_producto);
        Productos p = productosService.TraerProductoPorId(idProducto);

        if (p != null) {
            productos.add(p);
            System.out.println("se agrego correctamente " + p.getDescripcion());

            // TRUCO: flashAttribute viaja de forma segura solo en la siguiente redirección
            redirectAttributes.addFlashAttribute("mensajeAlerta", "¡Se añadió correctamente: " + p.getDescripcion() + "!");
        }

        // REDIRECCIÓN LIMPIA: Le decimos al navegador que cambie de URL y viaje al ancla
        return "redirect:/mostrar/carrito#carrito-compras";
    }

    @GetMapping("/mostrar/carrito")
    public String mostrarCarrito(Model model, HttpServletResponse response) {


        // Cargamos tus datos normalmente
        model.addAttribute("elementosEnCarrito", productos);
        model.addAttribute("productos", productosService.listarProductos());
        model.addAttribute("ofertas", ofertasService.obtenerTodasLasOfertas());

        return "index";
    }
}