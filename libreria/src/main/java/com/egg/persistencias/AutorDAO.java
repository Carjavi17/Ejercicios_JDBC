package com.egg.persistencias;

import java.util.List;

import com.egg.entidades.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AutorDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();


    public void guardarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public Autor buscarAutor(int id) throws Exception {
        return em.find(Autor.class, id);
    }

    public void actualizarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminarAutor(int id) throws Exception {
        Autor autor = em.find(Autor.class, id);
        if (autor != null) {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        }
    }

        public List<Autor> listarTodos() throws Exception {
        return em.createQuery("SELECT a FROM Autor a WHERE a.alta = true", Autor.class).getResultList();
    }
    
}
