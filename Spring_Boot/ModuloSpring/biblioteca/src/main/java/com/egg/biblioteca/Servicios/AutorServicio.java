package com.egg.biblioteca.Servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egg.biblioteca.Entidades.Autor;
import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Respositorios.AutorRepositorio;
import jakarta.transaction.Transactional;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiExcepcion {

        validar(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepositorio.save(autor);
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id) throws MiExcepcion {
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }

    public Autor buscarAutor(UUID id) {
        return autorRepositorio.findById(id).orElse(null);
    }

    @Transactional
    public Autor getOne(UUID id) {
        return autorRepositorio.getOne(id);
    }

    public Autor buscarPorNombre(String nombre) {
        return autorRepositorio.findByNombre(nombre).get();
    }

    public void borrarAutor(UUID id) {
        autorRepositorio.deleteById(id);
    }

    public List<Autor> listarAutores() {
        return autorRepositorio.findAll();
    }

    private void validar(String nombre) throws MiExcepcion {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("el nombre no puede ser nulo o estar vacío");
        }
    }

}
