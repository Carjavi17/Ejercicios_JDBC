package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Autor;
import com.egg.persistencias.AutorDAO;

public class AutorServicio {

    private final AutorDAO daoAutor;

    public AutorServicio() {
        this.daoAutor = new AutorDAO();
    }

    public void crearAutor(String nombre, Boolean alta) {

        try {
            Autor autorNuevo = new Autor();

            autorNuevo.setNombre(nombre);
            autorNuevo.setAlta(alta);

            daoAutor.guardarAutor(autorNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el autor");
        }
    }

    public Autor buscarAutorPorId(int id) throws Exception {
        return daoAutor.buscarAutor(id);
    }

    public Autor buscarAutorPorNombre(String nombre) throws Exception {
        return daoAutor.buscarAutoresPorNombre(nombre).get(0);
    }

    public void actualizarAutor(int id, String nombre, Boolean alta) throws Exception {

        Autor autor = daoAutor.buscarAutor(id);

        try {
            autor.setAlta(alta);
            autor.setNombre(nombre);
            daoAutor.actualizarAutor(autor);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se actualizo el autor");
        }

    }

    public void eliminarAutor(int id) throws Exception {
        Autor autor = daoAutor.buscarAutor(id);

        if (autor != null) {
            String nombre = autor.getNombre();
            Boolean alta = !autor.getAlta();
            actualizarAutor(id, nombre, alta);
        }
    }

    public void listarAutores() throws Exception {
        List<Autor> autores = daoAutor.listarTodos();
        for (Autor autor : autores) {
            System.out.println("-" + autor.getNombre());
        }

    }

}
