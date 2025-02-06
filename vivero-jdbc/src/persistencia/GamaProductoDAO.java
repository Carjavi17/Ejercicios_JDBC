package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.GamaProducto;

public class GamaProductoDAO extends DAO {

    public class EmpleadoDAO extends DAO {


    public void guardarGama(GamaProducto gamaProducto) throws Exception {
        if (gamaProducto == null) {
            throw new Exception("La Gama no puede ser nulo");
        }
        String sql = "INSERT INTO gama_producto (gama, descripcion_texto, descripcion_html, imagen) VALUES ('"

                + gamaProducto.getGama() + "', '"
                + gamaProducto.getDescripcionTexto() + "', '"
                + gamaProducto.getDescripcionHtml() + "')"                
                + gamaProducto.getImagen() + "')";
        insertarModificarEliminarDataBase(sql);
    }


    public List<GamaProducto> listarTodosLosGama() throws Exception {
        String sql = "SELECT id_gama, gama, descripcion_texto, descripcion_html FROM gama_producto";
        consultarDataBase(sql);
        List<GamaProducto> gamaProductos = new ArrayList<>();
        while (resultSet.next()) {
            GamaProducto gamaProducto = new GamaProducto();
            gamaProducto.setIdGama(resultSet.getInt("id_gama"));
            gamaProducto.setGama(resultSet.getString("gama"));
            gamaProducto.setDescripcionTexto(resultSet.getString("descripcion_texto"));
            gamaProducto.setDescripcionHtml(resultSet.getString("descripcion_html"));
            gamaProductos.add(gamaProducto);
        }
        return gamaProductos;
    }

    public void eliminarGamaPorId(int id) throws Exception {
        String sql = "DELETE FROM gama_producto WHERE id_gama = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}

}
