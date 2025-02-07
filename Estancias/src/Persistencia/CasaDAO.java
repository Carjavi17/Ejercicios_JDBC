package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Entidades.Casa;

public class CasaDAO extends DAO{

    public void guardarCasa(Casa casa) throws Exception {
        if (casa == null) {
            throw new Exception("La casa no puede ser nula");
        }
        String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda ) VALUES ('"

                + casa.getCalle() + "', '"
                + casa.getNumero() + "', '"
                + casa.getCodigoPostal() + "')"
                + casa.getCiudad() + "', '"
                + casa.getPais() + "', '"
                + casa.getFechaDesde() + "', '"
                + casa.getFechaHasta() + "')"
                + casa.getTiempoMinimo() + "', '"
                + casa.getTiempoMaximo() + "')"
                + casa.getPrecioHabitacion() + "', '"
                + casa.getTipoVivienda() + "', '";          
        insertarModificarEliminarDataBase(sql);
    }


    public List<Casa> listarTodosLasCasas() throws Exception {
        String sql = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas";
        consultarDataBase(sql);
        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
            Casa casa = new Casa();
            casa.setIdCasa(resultSet.getInt("id_casa"));
            casa.setCalle(resultSet.getString("calle"));
            casa.setNumero(resultSet.getInt("numero"));
            casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            casa.setCiudad(resultSet.getString("ciudad"));
            casa.setPais(resultSet.getString("pais"));
            casa.setFechaDesde(resultSet.getDate("fecha_desde"));
            casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
            casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
            casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
            casas.add(casa);
        }
        return casas;
    }

    public void eliminarCasaPorId(int id) throws Exception {
        String sql = "DELETE FROM casas WHERE id_casa = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
