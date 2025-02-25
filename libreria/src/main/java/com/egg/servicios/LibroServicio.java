package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import com.egg.persistencias.LibroDAO;

public class LibroServicio {

     private final LibroDAO daoLibro;

    public LibroServicio() {
        this.daoLibro = new LibroDAO();
    }

    public void crearLibro(String titulo, Integer anio, Integer ejemplares, Boolean alta, Autor autor, Editorial editorial) {

        try {
            Libro libroNuevo = new Libro();

            libroNuevo.setTitulo(titulo);
            libroNuevo.setAnio(anio);
            libroNuevo.setEjemplares(ejemplares);
            libroNuevo.setAlta(alta);
            libroNuevo.setAutor(autor);
            libroNuevo.setEditorial(editorial);

            daoLibro.guardarLibro(libroNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el Libro");
        }
    }

    public Libro buscarLibroPorIdLibro(int id) throws Exception {
        return daoLibro.buscarLibro(id);
    }

    public void actualizarLibro(int id, String titulo, Integer anio, Integer ejemplares, Boolean alta, Autor autor, Editorial editorial) throws Exception {

        Libro libro = daoLibro.buscarLibro(id);

        try {
            libro.setAlta(alta);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            daoLibro.actualizarLibro(libro);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se actualizo el Libro");
        }

    }

    public void eliminarLibro(int id) throws Exception {
        Libro libro = daoLibro.buscarLibro(id);

        if (libro != null) {
            String titulo = libro.getTitulo();
            Integer anio = libro.getAnio();
            Integer ejemplares = libro.getEjemplares();
            Autor autor = libro.getAutor();
            Editorial editorial = libro.getEditorial();
            Boolean alta = !libro.getAlta();
            actualizarLibro(id, titulo, anio, ejemplares, alta, autor, editorial);
        }
    }

    public void listarLibroes() throws Exception {
        List<Libro> libros = daoLibro.listarTodos();
        for (Libro libro : libros) {
            System.out.println("-" + libro.getTitulo());
        }

    }
    
}
