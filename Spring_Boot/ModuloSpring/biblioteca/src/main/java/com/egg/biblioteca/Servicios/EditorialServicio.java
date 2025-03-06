package com.egg.biblioteca.Servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.biblioteca.Entidades.Editorial;
import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Respositorios.EditorialRepositorio;

import jakarta.transaction.Transactional;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiExcepcion {

        validar(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);

    }

    @Transactional
    public void modificarEditorial(String nombre, UUID id) throws MiExcepcion {
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();

            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }
    }

    @Transactional
    public Editorial getOne(UUID id) {
        return editorialRepositorio.getOne(id);
    }

    private void validar(String nombre) throws MiExcepcion {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("el nombre no puede ser nulo o estar vacío");
        }
    }

    public List<Editorial> listarEditoriales() {
        return editorialRepositorio.findAll();
    }
}