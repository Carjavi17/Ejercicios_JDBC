package com.egg.persistencias;

import com.egg.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EditorialDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();


    public void guardarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorial(int id) throws Exception {
        return em.find(Editorial.class, id);
    }

    public void actualizarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorial(int id) throws Exception {
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
        }
    }
    
}
