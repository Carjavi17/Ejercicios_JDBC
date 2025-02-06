package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Pago;

public class PagoDAO extends DAO {

     public void guardarPago(Pago pago) throws Exception {
        if (pago == null) {
            throw new Exception("El pago no puede ser nulo");
        }
        String sql = "INSERT INTO oficina (id_cliente, forma_pago, id_transaccion, fecha_pago, total) VALUES ('"

                + pago.getIdCliente() + "', '"
                + pago.getFormaPago() + "', '"
                + pago.getIdTransaccion() + "')"
                + pago.getFechaPago() + "', '"
                + pago.getTotal() + "')";
        insertarModificarEliminarDataBase(sql);
    }


    public List<Pago> listarTodasLosPagos() throws Exception {
        String sql = "SELECT id_pago, id_cliente, forma_pago, id_transaccion FROM pago";
        consultarDataBase(sql);
        List<Pago> pagos = new ArrayList<>();
        while (resultSet.next()) {
            Pago pago = new Pago();
            pago.setIdPago(resultSet.getInt("id_pago"));
            pago.setIdCliente(resultSet.getInt("id_cliente"));
            pago.setFormaPago(resultSet.getString("forma_pago"));
            pago.setIdTransaccion(resultSet.getString("id_transaccion"));
            pagos.add(pago);
        }
        return pagos;
    }

    public void eliminarPagoPorId(int id) throws Exception {
        String sql = "DELETE FROM pago WHERE id_pago = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
