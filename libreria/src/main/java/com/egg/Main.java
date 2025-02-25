package com.egg;

import com.egg.servicios.AutorServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static final String CLEAR = "\033[H\033[2J";
    public static void main(String[] args) throws Exception {     
               

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        //EntityManager em = emf.createEntityManager();

        AutorServicio autorServicio = new AutorServicio();

        System.out.println(CLEAR);

        //autorServicio.crearAutor("Fernando", true);
        //autorServicio.crearAutor("Jose", true);

        //autorServicio.listarAutores();

        System.out.println(autorServicio.buscarAutorPorNombre("F").toString());



    }
}