package com.egg;

import com.egg.servicios.AutorServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception {
        

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        //EntityManager em = emf.createEntityManager();

        AutorServicio autorServicio = new AutorServicio();

        //autorServicio.crearAutor("Fernando", true);
        //autorServicio.crearAutor("Jose", true);

        autorServicio.listarAutores();



    }
}