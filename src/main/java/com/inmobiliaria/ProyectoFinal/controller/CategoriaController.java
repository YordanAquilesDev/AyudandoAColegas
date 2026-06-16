package com.inmobiliaria.ProyectoFinal.controller;
import org.springframework.ui.Model;
import com.inmobiliaria.ProyectoFinal.entity.Categoria;
import com.inmobiliaria.ProyectoFinal.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }




    @GetMapping("/lista")
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategoriasHtml", categoriaService.obtenerCategorias());
        return "html/Administrador";
    }
}