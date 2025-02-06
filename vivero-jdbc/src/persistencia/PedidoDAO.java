package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Pedido;

public class PedidoDAO extends DAO {

 public void guardarPedido(Pedido pedido) throws Exception {
        if (pedido == null) {
            throw new Exception("El pago no puede ser nulo");
        }
        String sql = "INSERT INTO oficina (codigo_pedido, fecha_pedido, fecha_espera, fecha_entrega) VALUES ('"

                + pedido.getCodigoPedido() + "', '"
                + pedido.getFechaPedido() + "', '"
                + pedido.getFechaEspera() + "')"
                + pedido.getFechaEntrega() + "', '";
        insertarModificarEliminarDataBase(sql);
    }


    public List<Pedido> listarTodasLosPedidos() throws Exception {
        String sql = "SELECT id_pedido, codigo_pedido, fecha_pedido, fecha_espera FROM pedido";
        consultarDataBase(sql);
        List<Pedido> pedidos = new ArrayList<>();
        while (resultSet.next()) {
            Pedido pedido = new Pedido();
            pedido.setIdPedido(resultSet.getInt("id_pedido"));
            pedido.setCodigoPedido(resultSet.getInt("codigo_pedido"));
            pedido.setFechaPedido(resultSet.getDate("fecha_pedido"));
            pedido.setFechaEspera(resultSet.getDate("fecha_espera"));
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public void eliminarPedidoPorId(int id) throws Exception {
        String sql = "DELETE FROM pedido WHERE id_pedido = " + id;
        insertarModificarEliminarDataBase(sql);
    }    
}
