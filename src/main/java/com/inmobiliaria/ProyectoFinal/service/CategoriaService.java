package com.inmobiliaria.ProyectoFinal.service;

import com.inmobiliaria.ProyectoFinal.entity.Categoria;
import com.inmobiliaria.ProyectoFinal.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

   public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria guardar(Categoria categoria) {
        /**
         * validar que el obejto de la clase categorio no venga
         * con datos incompletos
         */
        if(categoria==null){
            throw new IllegalArgumentException("La categoría no puede ser nula o venir vacía.");
        }
        if(categoria.getNombreCategoria()==null){
            throw new IllegalArgumentException("No se puede guardar una categoria sin nombre en la base de datos");
        }

        return categoriaRepository.save(categoria);
    }


    public Categoria actualizar(Categoria categoria) {
       if(categoria.getIdCategoria()<0){
           throw new IllegalArgumentException("No se puede actualizar una categoria con id Negativo");
       }
       try{
          return  categoriaRepository.save(categoria);
       }catch(Exception e){
           throw new RuntimeException("Error al actualizar la categoria"+ e.getMessage());
       }
    }

    public void eliminar(int id) {
       if(id<0){
           throw new IllegalArgumentException("No se puede eliminar una categoria con id Negativo");

       }
       categoriaRepository.deleteById(id);
    }

    public List<Categoria> obtenerCategorias() {
       try{
          return  categoriaRepository.findAll();
       }catch(Exception e){
           throw new RuntimeException("Error al obtener la categoria"+ e.getMessage());
       }
    }

}
