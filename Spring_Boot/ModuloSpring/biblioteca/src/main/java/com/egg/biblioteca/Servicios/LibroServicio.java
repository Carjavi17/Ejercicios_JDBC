package com.egg.biblioteca.Servicios;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.Entidades.*;
import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Respositorios.*;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial)
            throws MiExcepcion {

        if (isbn == null || titulo == null || titulo.trim().isEmpty() || ejemplares == null || idAutor == null
                || idEditorial == null) {
            throw new MiExcepcion("Todos los campos son obligatorios.");
        }

        Optional<Autor> autorOpt = autorRepositorio.findById(idAutor);
        if (!autorOpt.isPresent()) {
            throw new MiExcepcion("El autor seleccionado no existe.");
        }

        Optional<Editorial> editorialOpt = editorialRepositorio.findById(idEditorial);
        if (!editorialOpt.isPresent()) {
            throw new MiExcepcion("La editorial seleccionada no existe.");
        }

        Libro libro = new Libro(
                isbn,
                titulo,
                ejemplares,
                new Date(),
                autorOpt.get(),
                editorialOpt.get());

        libroRepositorio.save(libro);
    }

    @Transactional
    public void crearLibro(Libro libro) {

        Optional<Autor> autor = autorRepositorio.findById(libro.getAutor().getId());

        if (!autor.isPresent()) {
            throw new IllegalArgumentException("El autor no existe");
        }

        Optional<Editorial> editorial = editorialRepositorio.findById(libro.getEditorial().getId());

        if (!editorial.isPresent()) {
            throw new IllegalArgumentException("La editorial no existe");
        }

        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {

        List<Libro> libros = new ArrayList<>();

        libros = libroRepositorio.findAll();
        return libros;
    }

    @Transactional
    public void modificarLibro(String nombre, UUID id) {
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();

            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }
    }

}
