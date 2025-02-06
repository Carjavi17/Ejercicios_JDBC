package servicios;

import java.util.List;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
    private ClienteDAO cd;

    public ClienteServicio() {
        this.cd = new ClienteDAO();
    }

    public Cliente crearNuevoCliente(Integer idCliente, int codigoC, String nombreCli, String nombreContacto,
            String apellidoContacto,
            String telefono, String fax, String ciudad, String region, String pais, String codigoPostal,
            int idEmpleado, double limiteCredito) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
        validacionesNyA(nombreContacto, apellidoContacto);
        Cliente cliente = new Cliente(idCliente, codigoC, nombreCli, nombreContacto, apellidoContacto, telefono, fax,
                ciudad, region,
                pais, codigoPostal, idEmpleado, limiteCredito);
        cd.guardarCliente(cliente);
        return cliente;
    }

    public void validacionesNyA(String nombreContacto, String apellidoContacto) throws Exception {
        if (nombreContacto == null) {
            throw new Exception("El nombre del contacto no puede ser nulo.");
        }
        if (apellidoContacto == null) {
            throw new Exception("El apellido del contacto no puede ser nulo.");
        }
    }

    public void validarId(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("El id del contacto no puede ser nulo.");
        }
        if (cd.buscarClientePorId(id) != null) {
            throw new Exception("El id ingresado ya existe");
        }
    }

    public void validarCodigoCliente(int idC) throws Exception {
        if (cd.buscarClientePorId(idC) != null) {
            throw new Exception("El id ingresado ya existe");
        }
    }

    public void obtenerTodosLosClientes() throws Exception {
        String query = "SELECT * FROM cliente WHERE limite_credito > 50000";

        List<Cliente> listaClientes = cd.listarTodosLosClientes(query);

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNombreCliente());
            System.out.println(cliente.getLimiteCredito());
        }
    }

    public void buscarClientePorCodigo(Integer codigo) throws Exception {
        if (codigo == null) {
            System.out.println("El codigo no puede ser nulo");
        } else {
            Cliente cliente = cd.buscarClientePorCodigo(codigo);

            System.out.println(cliente.getApellidoContacto() + " - " + cliente.getCodigoCliente());
        }
    }
}
