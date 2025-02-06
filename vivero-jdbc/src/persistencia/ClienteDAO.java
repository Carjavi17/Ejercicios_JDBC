package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;

public class ClienteDAO extends DAO {

    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, país, codigo_postal, id_empleado, limite_credito ) VALUES ('"

                + cliente.getCodigoCliente() + "', '"
                + cliente.getCodigoCliente() + "', '"
                + cliente.getNombreContacto() + "')"
                + cliente.getApellidoContacto() + "', '"
                + cliente.getTelefono() + "', '"
                + cliente.getFax() + "')"
                + cliente.getCiudad() + "', '"
                + cliente.getRegion() + "', '"
                + cliente.getPais() + "')"
                + cliente.getCodigoPostal() + "', '"
                + cliente.getIdEmpleado() + "', '"
                + cliente.getLimiteCredito() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Cliente> listarTodosLosClientes() throws Exception {
        String sql = "SELECT id_cliente, nombre_cliente, nombre_contacto, apellido_contacto FROM cliente";
        consultarDataBase(sql);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
            cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
            cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public void eliminarClientePorId(int id) throws Exception {
        String sql = "DELETE FROM cliente WHERE id_cliente = " + id;
        insertarModificarEliminarDataBase(sql);
    }

    public Cliente buscarClientePorId(int id) throws Exception {
        String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente WHERE id_cliente = " + id;

        consultarDataBase(sql);

        resultSet.next();

        Cliente cliente = new Cliente();
        cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
        System.out.println(cliente.getNombreContacto());

        return cliente;
    }

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {
        String sql = "SELECT * FROM cliente WHERE codigo_cliente = " + codigo;
        consultarDataBase(sql);
        Cliente cliente = null;
        while (resultSet.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setCodigoCliente(resultSet.getInt("codigo_cliente"));
            cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
            cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
            cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
            cliente.setTelefono(resultSet.getString("telefono"));
            cliente.setFax(resultSet.getString("fax"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setCodigoPostal(resultSet.getString("pais"));
            cliente.setRegion(resultSet.getString("region"));
            cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
            cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));
        }
        return cliente;
    }

    public List<Cliente> listarTodosLosClientes(String sql) throws Exception {
        consultarDataBase(sql);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(resultSet.getInt("id_cliente"));
        cliente.setNombreCliente(resultSet.getString("nombre_contacto"));
        cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
        cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));
        clientes.add(cliente);
        }
        return clientes;
        }

}
