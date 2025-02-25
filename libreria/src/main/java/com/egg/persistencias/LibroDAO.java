package com.egg.persistencias;

import java.util.List;
import com.egg.entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibroDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarLibro(Libro libro) throws Exception {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public Libro buscarLibro(int isbn) throws Exception {
        return em.find(Libro.class, isbn);
    }

    public void actualizarLibro(Libro libro) throws Exception {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public void eliminarLibro(int id) throws Exception {
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        }
    }

    public List<Libro> listarTodos() throws Exception {
        return em.createQuery("SELECT l FROM Libro l WHERE a.alta = true", Libro.class).getResultList();
    }

    public Libro buscarLibro(String titulo){
        return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE:tit",Libro.class).setParameter("tit", titulo).getResultList().get(0);
    }
    public List<Libro> buscarLibrosAutor(String autor){
        return em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE l.alta = TRUE AND a.nombre LIKE: author",Libro.class).setParameter("author", autor).getResultList();
    }

    public List<Libro> buscarLibrosEditorial(String editorial){
        return em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE l.alta = TRUE AND e.nombre LIKE: editorial",Libro.class).setParameter("editorial", editorial).getResultList();
    }

}
