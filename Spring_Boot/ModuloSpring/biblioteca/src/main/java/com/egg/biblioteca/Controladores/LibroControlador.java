package com.egg.biblioteca.Controladores;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Servicios.AutorServicio;
import com.egg.biblioteca.Servicios.EditorialServicio;
import com.egg.biblioteca.Servicios.LibroServicio;

@Controller
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;
    
    @Autowired
    private AutorServicio autorServicio;
    
    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar(ModelMap model) {
        model.put("autores", autorServicio.listarAutores());
        model.put("editoriales", editorialServicio.listarEditoriales());
        return "libro_form.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model) {

        model.put("libros", libroServicio.listarLibros());

        return "libro_list.html";
    }

    @PostMapping("/registro")
    public String registro(
        @RequestParam(required = false) Long isbn,
        @RequestParam (required = false) String titulo,
        @RequestParam(required = false) Integer ejemplares,
        @RequestParam (required = false) UUID idAutor,
        @RequestParam (required = false) UUID idEditorial,
        ModelMap model) {

        try {
            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            model.put("exito", "Libro registrado con éxito.");
            
            return "redirect:/";

        } catch (MiExcepcion ex) {
            model.put("error", "Error al registrar el libro: " + ex.getMessage());
            return "libro_form.html";
        }
    }
}
