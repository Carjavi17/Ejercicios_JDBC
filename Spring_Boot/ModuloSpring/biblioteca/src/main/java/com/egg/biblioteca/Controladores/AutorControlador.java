package com.egg.biblioteca.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Servicios.AutorServicio;

import java.util.UUID;


@Controller
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;


    
    @GetMapping("/registrar") 
    public String registrar() {
        return "autor_form.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model) {

        model.put("autores", autorServicio.listarAutores());

        return "autor_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap model) {
        model.put("autor", autorServicio.getOne(id));
        return "autor_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, ModelMap model) {
        
        try {
            autorServicio.modificarAutor(nombre, id);
            return "redirect:../lista";

        } catch (MiExcepcion ex) {
            model.put("error", "Error al modificar el autor: " + ex.getMessage());
        }
        return "autor_modificar.html";
    }   

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap model){

        try {            
            autorServicio.crearAutor(nombre);
            model.put("exito", "Autor registrado con éxito."); 

        } catch (MiExcepcion ex) {   
            
            model.put("error", "Error al registrar el autor: " + ex.getMessage());
            return "autor_form.html";
        }        
        return "index.html";

    }

    
}
