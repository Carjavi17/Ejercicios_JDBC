package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Producto;

public class ProductoDAO extends DAO {

     public void guardarProducto(Producto producto) throws Exception {
        if (producto == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        String sql = "INSERT INTO cliente (codigo_producto, nombre, id_gama, dimensiones, proveedor, descripcion, cantidad_stock, precio_venta, precio_proveedor) VALUES ('"

                + producto.getCodigoProducto() + "', '"
                + producto.getNombre() + "', '"
                + producto.getIdGama() + "')"
                + producto.getDimensiones() + "', '"
                + producto.getProveedor() + "', '"
                + producto.getDescripcion() + "')"
                + producto.getCantidadStock() + "', '"
                + producto.getPrecioVenta() + "', '"               
                + producto.getPrecioProveedor() + "')";
        insertarModificarEliminarDataBase(sql);
    }


    public List<Producto> listarTodosLosProductos() throws Exception {
        String sql = "SELECT id_producto, codigo_producto, nombre, id_gama FROM cliente";
        consultarDataBase(sql);
        List<Producto> productos = new ArrayList<>();
        while (resultSet.next()) {
            Producto producto = new Producto();
            producto.setIdProducto(resultSet.getInt("id_producto"));
            producto.setCodigoProducto(resultSet.getInt("codigo_producto"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setIdGama(resultSet.getInt("id_gama"));
            productos.add(producto);
        }
        return productos;
    }

    public void eliminarProductoPorId(int id) throws Exception {
        String sql = "DELETE FROM producto WHERE id_producto = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
