package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Entidades.Cliente;

public class ClienteDAO extends DAO{

    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES ('"

                + cliente.getNombre() + "', '"
                + cliente.getCalle() + "', '"
                + cliente.getNumero() + "')"
                + cliente.getCodigoPostal() + "', '"
                + cliente.getCiudad() + "')"
                + cliente.getPais() + "', '"
                + cliente.getEmail() + "', '";          
        insertarModificarEliminarDataBase(sql);
    }


    public List<Cliente> listarTodosLosClientes() throws Exception {
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes";
        consultarDataBase(sql);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setCalle(resultSet.getString("calle"));
            cliente.setNumero(resultSet.getInt("numero"));
            cliente.setCodigoPostal(resultSet.getInt("codigo_postal"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setEmail(resultSet.getString("email"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public void eliminarClientePorId(int id) throws Exception {
        String sql = "DELETE FROM clientes WHERE id_cliente = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
