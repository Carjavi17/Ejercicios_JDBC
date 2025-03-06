package com.egg.biblioteca.Controladores;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Servicios.EditorialServicio;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "editorial_form.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model) {

        model.put("editoriales", editorialServicio.listarEditoriales());

        return "editorial_list.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap model) {

        try {
            editorialServicio.crearEditorial(nombre);

            model.put("exito", "Editorial registrada con éxito.");
        } catch (MiExcepcion ex) {

            model.put("error", "Error al registrar la editorial: " + ex.getMessage());
            return "editorial_form.html";
        }
        return "index.html";

    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap model) {
        model.put("editorial", editorialServicio.getOne(id));
        return "editorial_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, ModelMap model) {
        
        try {
            editorialServicio.modificarEditorial(nombre, id);
            return "redirect:../lista";

        } catch (MiExcepcion ex) {
            model.put("error", "Error al modificar el autor: " + ex.getMessage());
        }
        return "editorial_modificar.html";
    } 
}