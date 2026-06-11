package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.repository.ProductoRepository;
import org.springframework.stereotype.*;
import com.inmobiliaria.ProyectoFinal.entity.Productos;
import java.util.Optional;

@Service
public class ProductosService {
    

    private ProductoRepository productoRepository;

    public Productos guardar(Productos producto){
        return productoRepository.save(producto);
    }

    public Productos actualizar(Productos productos){
        return productoRepository.save(productos);

    }

    public Productos TraerProductoPorId(int id){
        Integer idInteger=id;
       Productos p=productoRepository.findById(idInteger).orElse(null);
        return p;
        }


}
