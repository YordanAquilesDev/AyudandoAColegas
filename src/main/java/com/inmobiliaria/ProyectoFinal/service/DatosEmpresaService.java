package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.entity.DatosEmpresa;
import com.inmobiliaria.ProyectoFinal.repository.DatosEmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class DatosEmpresaService {
    DatosEmpresaRepository datosEmpresaRepository;

    public DatosEmpresaService(DatosEmpresaRepository datosEmpresaRepository) {
        this.datosEmpresaRepository = datosEmpresaRepository;
    }

    public DatosEmpresa traerDatosEmpresa(){

        return datosEmpresaRepository.findById(1).orElse(null);

    }


}
