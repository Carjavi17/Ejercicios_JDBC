package com.egg.persistencia;

import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpleadoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarEmpleadoina(Empleado empleado) throws Exception{
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    public Empleado buscarEmpleado(int id) throws Exception{
        return em.find(Empleado.class, id);
    }

    public void actualizarEmpleado(Empleado empleado) throws Exception{
        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();
    }

    public void eliminarEmpleado(int id) throws Exception{
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
        }
    }
    
    
}
