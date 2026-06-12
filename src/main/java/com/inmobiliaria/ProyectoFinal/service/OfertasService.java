package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.entity.DetalleOferta;
import com.inmobiliaria.ProyectoFinal.entity.Ofertas;
import com.inmobiliaria.ProyectoFinal.repository.DetalleOfertaRepository;
import com.inmobiliaria.ProyectoFinal.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OfertasService {

    @Autowired
    private OfertaRepository ofertasRepository;

    @Autowired
    private DetalleOfertaRepository detalleOfertaRepository;

    // El servicio centraliza la lógica para listar
    public List<Ofertas> obtenerTodasLasOfertas() {
        return ofertasRepository.findAll();
    }

    // El servicio junta los datos generales y los detalles en un solo lugar
    public Ofertas obtenerOfertaPorId(int id) {
        return ofertasRepository.findById(id).orElse(null);
    }

    public List<DetalleOferta> obtenerDetallesDeOferta(Integer idOferta) {
        return detalleOfertaRepository.findAllById(Collections.singleton(idOferta));
    }
    
    // Aquí podrías meter lógica de compra en el futuro:
    // public void procesarCompra(int idOferta) { ... }
}