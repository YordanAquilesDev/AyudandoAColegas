package com.inmobiliaria.ProyectoFinal.repository;

import com.inmobiliaria.ProyectoFinal.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
}
