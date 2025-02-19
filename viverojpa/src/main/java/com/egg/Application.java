package com.egg;

import com.egg.servicios.ClienteServicio;
//import com.egg.servicios.OficinaServicio;
import com.egg.servicios.OficinaServicio;
import com.egg.servicios.ProductoServicio;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) throws Exception {

        /*
         * EntityManagerFactory emf =
         * Persistence.createEntityManagerFactory("ViveroPU");
         * EntityManager em = emf.createEntityManager();
         */

        // Instanciar la clase OficinaServicio para acceder a sus métodos
        //OficinaServicio oficinaServicio = new OficinaServicio();
        //ClienteServicio clienteServicio = new ClienteServicio();
        ProductoServicio productoServicio = new ProductoServicio();

        // Llamar al método del servicio para crear una nueva oficina

        /*
        oficinaServicio.crearOficna("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111",
                "CP5000");
        */

        //clienteServicio.crearCliente("Carlos", "Buenos Aires", "CP5000", "11111111", 1, 100000.00, "Carlos", "Carlos", "Argentina", "Cuyo", "111111111");

        //oficinaServicio.listarOficinas();

        //clienteServicio.listarClientes();
        productoServicio.listarProductos();

        
    }
}
