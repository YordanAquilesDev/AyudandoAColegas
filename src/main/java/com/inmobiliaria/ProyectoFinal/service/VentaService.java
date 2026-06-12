package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.entity.Productos;
import com.inmobiliaria.ProyectoFinal.repository.OfertaRepository;
import com.inmobiliaria.ProyectoFinal.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {
    private ProductosService productosService;
    private OfertasService ofertasService;


    public boolean RegistrarVenta(List<Productos> productos,String tipoVenta){
        if(tipoVenta.equals("productos")){
            List<Productos> productosActualizados = new ArrayList();
            for(Productos producto:productos){
                producto.setCantidad(producto.getCantidad()-1);
                Productos productoss = productosService.actualizar(producto);
                productosActualizados.add(productoss);
            }
            return !productosActualizados.isEmpty();
        }else{
           return false;


        }

    }


    public boolean RegistrarVenta(Integer id_oferta){

        return true;
    }

}
