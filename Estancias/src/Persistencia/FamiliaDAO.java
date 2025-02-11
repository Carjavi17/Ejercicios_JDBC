package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Entidades.Familia;

public class FamiliaDAO extends DAO {
    public void guardarFamilia(Familia familia) throws Exception {
        if (familia == null) {
            throw new Exception("La familia no puede ser nula");
        }
        String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ('"

                + familia.getNombre() + "', '"
                + familia.getEdadMinima() + "', '"
                + familia.getEdadMaxima() + "')"
                + familia.getNumHijos() + "', '"
                + familia.getEmail() + "', '"
                + familia.getIdCasaFamilia() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Familia> listarTodosLasFamilias() throws Exception {
        String sql = "SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia FROM familias";
        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            Familia familia = new Familia();
            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
            familias.add(familia);
        }
        return familias;
    }

    public void eliminarFamiliaPorId(int id) throws Exception {
        String sql = "DELETE FROM familias WHERE id_familia = " + id;
        insertarModificarEliminarDataBase(sql);
    }

    public List<Familia> listarTodasLasFamilias(int numHijos, int edadMaxima) throws Exception {
        
        String sql = "SELECT * FROM familias WHERE num_hijos >= " + numHijos + " AND edad_maxima < " + 
        edadMaxima;

        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            Familia familia = new Familia();
            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
            familias.add(familia);
        }
        return familias;
    }

    public List<Familia> listarTodasLasFamilias(String email) throws Exception {
        
        String sql = "SELECT * FROM familias WHERE email LIKE '%" + email + "%'" ;

        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            Familia familia = new Familia();
            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
            familias.add(familia);
        }
        return familias;
    }

}
