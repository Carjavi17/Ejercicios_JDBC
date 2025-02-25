package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.persistencias.EditorialDAO;

public class EditorialServicio {

    private final EditorialDAO daoEditorial;

    public EditorialServicio() {
        this.daoEditorial = new EditorialDAO();
    }

    public void crearEditorial(String nombre, Boolean alta) {

        try {
            Editorial editorialNuevo = new Editorial();

            editorialNuevo.setNombre(nombre);
            editorialNuevo.setAlta(alta);

            daoEditorial.guardarEditorial(editorialNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el editorial");
        }
    }

    public Editorial buscarEditorialPorId(int id) throws Exception {
        return daoEditorial.buscarEditorial(id);
    }

    public void actualizarEditorial(int id, String nombre, Boolean alta) throws Exception {

        Editorial editorial = daoEditorial.buscarEditorial(id);

        try {
            editorial.setAlta(alta);
            editorial.setNombre(nombre);
            daoEditorial.actualizarEditorial(editorial);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se actualizo el editorial");
        }

    }

    public void eliminarEditorial(int id) throws Exception {
        Editorial editorial = daoEditorial.buscarEditorial(id);

        if (editorial != null) {
            String nombre = editorial.getNombre();
            Boolean alta = !editorial.getAlta();
            actualizarEditorial(id, nombre, alta);
        }
    }

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        return daoEditorial.buscarEditorialPorNombre(nombre).get(0);
    }

    public void listarEditoriales() throws Exception {
        List<Editorial> editoriales = daoEditorial.listarTodos();
        for (Editorial editorial : editoriales) {
            System.out.println("-" + editorial.getNombre());
        }

    }

}
