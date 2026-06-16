package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.repository.ProductoRepository;
import org.springframework.stereotype.*;
import com.inmobiliaria.ProyectoFinal.entity.Productos;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    

    private final ProductoRepository productoRepository;

    public ProductosService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

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

        public List<Productos> listarProductos(){
        return productoRepository.findAll();
        }


}
