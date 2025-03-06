package com.egg.biblioteca.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControl {

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


}