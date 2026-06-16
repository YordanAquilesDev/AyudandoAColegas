package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.entity.DetalleOferta;
import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.repository.DetalleOfertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOfertaService {

    private final DetalleOfertaRepository detalleOfertaRepository;

    public DetalleOfertaService(DetalleOfertaRepository detalleOfertaRepository) {
        this.detalleOfertaRepository = detalleOfertaRepository;
    }

    public List<DetalleOferta> listarOfertas(){
        return detalleOfertaRepository.findAll();
    }

    public DetalleOferta traerPorId(Integer id){
        return detalleOfertaRepository.findById(id).orElse(null);
    }
}
