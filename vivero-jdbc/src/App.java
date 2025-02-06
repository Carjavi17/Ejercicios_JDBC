import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import persistencia.ClienteDAO;
import servicios.ClienteServicio;

public class App {
    public static void main(String[] args) throws Exception {

        /* 

        ClienteDAO clienteDAO = new ClienteDAO();

        List<Cliente> clientes = new ArrayList<>();

        clientes = clienteDAO.listarTodosLosClientes();
        
        for (Cliente cliente : clientes) {

            System.out.println(cliente.toString());            
        }    

        */       

        //clienteDAO.eliminarClientePorId(20);

         ClienteServicio nvoCliente = new ClienteServicio();

        nvoCliente.crearNuevoCliente(667, 222, null, null, "Gomez", null, null, null, null, null, null, 0, 0);
        
    }
}
