package com.inmobiliaria.ProyectoFinal.repository;

import com.inmobiliaria.ProyectoFinal.entity.DatosEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<DatosEmpresa, Integer> {
}
