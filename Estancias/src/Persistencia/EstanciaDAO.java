package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Entidades.Estancia;

public class EstanciaDAO extends DAO {

     public void guardarEstancia(Estancia estancia) throws Exception {
        if (estancia == null) {
            throw new Exception("La estancia no puede ser nula");
        }
        String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES ('"

                + estancia.getIdCliente() + "', '"
                + estancia.getIdCasa() + "', '"
                + estancia.getNombreHuesped() + "')"
                + estancia.getFechaDesde() + "', '"
                + estancia.getFechaHasta() + "', '";          
        insertarModificarEliminarDataBase(sql);
    }


    public List<Estancia> listarTodosLasEstancias() throws Exception {
        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias";
        consultarDataBase(sql);
        List<Estancia> estancias = new ArrayList<>();
        while (resultSet.next()) {
            Estancia estancia = new Estancia();
            estancia.setIdEstancia(resultSet.getInt("id_estancia"));
            estancia.setIdCliente(resultSet.getInt("id_cliente"));
            estancia.setIdCasa(resultSet.getInt("id_casa"));
            estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
            estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
            estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
            estancias.add(estancia);
        }
        return estancias;
    }

    public void eliminarEstanciaPorId(int id) throws Exception {
        String sql = "DELETE FROM estancias WHERE id_estancia = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
