package com.egg.persistencia;

import com.egg.entidades.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PedidoDAO {
     private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarPedido(Pedido pedido) throws Exception{
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
    }

    public Pedido buscarPedido(int id) throws Exception{
        return em.find(Pedido.class, id);
    }

    public void actualizarPedido(Pedido pedido) throws Exception{
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();
    }

    public void eliminarPedido(int id) throws Exception{
        Pedido pedido = em.find(Pedido.class, id);
        if (pedido != null) {
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();
        }
    }
    
}
