package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {

     private final ClienteDAO daoCliente;// Instancio a la unidad d persistencia para acceder a los metodos del EM


    public ClienteServicio() {
       this.daoCliente = new ClienteDAO();
    }


    public void crearCliente(String apellidoContacto, String ciudad, String codigoPostal,
            String fax, int idEmpleado, Double limite_credito, String nombreCliente, String nombreContacto,
            String pais, String region, String telefono) {


        try {
// Crear una nueva instancia de Oficina
            Cliente clienteNuevo = new Cliente();


            clienteNuevo.setApellidoContacto(apellidoContacto);
            clienteNuevo.setCiudad(ciudad);
            clienteNuevo.setCodigoPostal(codigoPostal);
            clienteNuevo.setFax(fax);
            clienteNuevo.setIdEmpleado(idEmpleado);
            clienteNuevo.setLimite_credito(limite_credito);
            clienteNuevo.setNombreCliente(nombreCliente);
            clienteNuevo.setNombreContacto(nombreContacto);
            clienteNuevo.setPais(pais);
            clienteNuevo.setRegion(region);
            clienteNuevo.setTelefono(telefono);


// Llamar al método de OficinaDAO para guardar la nueva oficina
            daoCliente.guardarCliente(clienteNuevo);


        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el cliente de manera correcta");
        }
    }

    
    public void listarClientes()throws Exception{
        List<Cliente> todosClientes = daoCliente.listarTodos();
        imprimirLista(todosClientes);
    }


    public void imprimirLista(List <Cliente> listaRecibida)throws Exception{
        for (Cliente unitariaCliente : listaRecibida){
            System.out.println(unitariaCliente.getNombreCliente() + " - " + unitariaCliente.getCodigoCliente() + " - " + unitariaCliente.getCiudad() + " - " + unitariaCliente.getPais() );
        }
    }

    public void listarClientes(String nombreRecibido) throws Exception {
        List<Cliente> clientesNombre = daoCliente.listarClientesPorNombre(nombreRecibido);
        imprimirListaPorNombre(clientesNombre);
    }


    // Imprimo solo lgunos datos de la BBDD
    public void imprimirListaPorNombre(List<Cliente> listaRecibida) {
        for (Cliente unitarioCliente : listaRecibida) {
            System.out.println(unitarioCliente.getIdCliente() + "-" + unitarioCliente.getApellidoContacto() + "-"
                    + unitarioCliente.getNombreContacto());
        }


    }

    
}
