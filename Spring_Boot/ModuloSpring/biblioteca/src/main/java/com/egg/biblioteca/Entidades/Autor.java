package com.egg.biblioteca.Entidades;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String nombre;

    public Autor() {
    }

    

    public Autor(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    
}
