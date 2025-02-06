package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.DetallePedido;

public class DetallePedidoDAO extends DAO {

    public void guardarDetallePedido(DetallePedido detallepedido) throws Exception {
        if (detallepedido == null) {
            throw new Exception("El detalle del pedido no puede ser nulo");
        }
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unidad, numero_linea ) VALUES ('"

                + detallepedido.getIdDetallePedido() + "', '"
                + detallepedido.getIdePedido() + "', '"
                + detallepedido.getIdProducto() + "')"
                + detallepedido.getCantidad() + "', '"
                + detallepedido.getPrecioUnitario() + "', '"
                + detallepedido.getNumeroLinea() + "')";
        insertarModificarEliminarDataBase(sql);
    }


    public List<DetallePedido> listarTodosLosDetallePedido() throws Exception {
        String sql = "SELECT id_detalle_pedido, cantidad, precio_unidad, numero_linea FROM detalle_pedido";
        consultarDataBase(sql);
        List<DetallePedido> detallePedidos = new ArrayList<>();
        while (resultSet.next()) {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setIdDetallePedido(resultSet.getInt("id_detalle_pedido"));
            detallePedido.setCantidad(resultSet.getInt("cantidad"));
            detallePedido.setPrecioUnitario(resultSet.getDouble("precio_unidad"));
            detallePedido.setNumeroLinea(resultSet.getShort("numero_linea"));
            detallePedidos.add(detallePedido);
        }
        return detallePedidos;
    }

    public void eliminarDetallePedidoPorId(int id) throws Exception {
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle_pedido = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
