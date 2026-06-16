package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.entity.DetalleOferta;
import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.entity.Productos;
import com.inmobiliaria.ProyectoFinal.repository.OfertaRepository;
import com.inmobiliaria.ProyectoFinal.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    private final ProductosService productosService;
    private final OfertasService ofertasService;
    private final UsuarioRepository usuarioRepository;
    public VentaService(ProductosService productosService, OfertasService ofertasService, UsuarioRepository usuarioRepository) {
        this.productosService = productosService;
        this.ofertasService = ofertasService;
        this.usuarioRepository = usuarioRepository;
    }


    public boolean RegistrarVenta(List<Productos> productos){

            List<Productos> productosActualizados = new ArrayList<>();
            for(Productos producto:productos){
                producto.setCantidad(producto.getCantidad()-1);
                Productos productoss = productosService.actualizar(producto);
                productosActualizados.add(productoss);
            }
            return !productosActualizados.isEmpty();


    }


    public boolean RegistrarVenta(Integer id_oferta){
        Ofertas ofe= ofertasService.obtenerOfertaPorId(id_oferta);
        if(ofe==null){
            return false;
        }else{
            for(DetalleOferta deta: ofe.getDetalles()){
                Productos pAntesDeActualizar= deta.getProducto();
                pAntesDeActualizar.setCantidad(pAntesDeActualizar.getCantidad()-deta.getCantidad());
                Productos productosActualizados=productosService.guardar(pAntesDeActualizar);
            }

            return  true;
        }


    }

}
