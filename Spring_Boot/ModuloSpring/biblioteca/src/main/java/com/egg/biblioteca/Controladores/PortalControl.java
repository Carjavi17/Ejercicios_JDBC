package com.egg.biblioteca.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Servicios.UsuarioServicio;

@Controller
@RequestMapping("/")
public class PortalControl {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrar")
    public String Registrar() {
        return "registro.html"; 
    }

    @GetMapping("/login")
    public String Login() {
        return "login.html"; 
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
                            @RequestParam String password2, ModelMap model) {
        try{
            usuarioServicio.registrar(nombre, email, password, password2);
            model.put("exito", "El usuario fue creado correctamente.");
            return "index.html";

        }catch (MiExcepcion ex){
            model.put("error", ex.getMessage());
            model.put("nombre", nombre);
            model.put("email", email);
            return "registro.html";
        }
    }


}