package com.inmobiliaria.ProyectoFinal.repository;

import com.inmobiliaria.ProyectoFinal.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {
}
