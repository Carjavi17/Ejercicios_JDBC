package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Oficina;

public class OficinaDAO extends DAO {

    public void guardarOficina(Oficina oficina) throws Exception {
        if (oficina == null) {
            throw new Exception("La oficina no puede ser nulo");
        }
        String sql = "INSERT INTO oficina (codigo_oficina, ciudad, pais, region, codigo_postal, telefono) VALUES ('"

                + oficina.getCodigoOficina() + "', '"
                + oficina.getCiudad() + "', '"
                + oficina.getPais() + "')"
                + oficina.getRegion() + "', '"
                + oficina.getCodigoPostal() + "')"                   
                + oficina.getTelefono() + "')";
        insertarModificarEliminarDataBase(sql);
    }


    public List<Oficina> listarTodasLasOficinas() throws Exception {
        String sql = "SELECT id_oficina, codigo_oficina, ciudad, pais FROM oficina";
        consultarDataBase(sql);
        List<Oficina> oficinas = new ArrayList<>();
        while (resultSet.next()) {
            Oficina oficina = new Oficina();
            oficina.setIdOficina(resultSet.getInt("id_oficina"));
            oficina.setCodigoOficina(resultSet.getInt("codigo_oficina"));
            oficina.setCiudad(resultSet.getString("ciudad"));
            oficina.setPais(resultSet.getString("pais"));
            oficinas.add(oficina);
        }
        return oficinas;
    }

    public void eliminarOficinaPorId(int id) throws Exception {
        String sql = "DELETE FROM oficina WHERE id_oficina = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
