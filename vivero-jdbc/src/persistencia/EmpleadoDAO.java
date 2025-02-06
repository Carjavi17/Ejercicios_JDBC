package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Empleado;


public class EmpleadoDAO extends DAO {

    public void guardarEmpleado(Empleado empleado) throws Exception {
        if (empleado == null) {
            throw new Exception("El empleado no puede ser nulo");
        }
        String sql = "INSERT INTO empleado (codigo_empleado, nombre, apellido, extension, email, id_oficina, id_jefe, puesto ) VALUES ('"

                + empleado.getCodigoEmpleado() + "', '"
                + empleado.getNombre() + "', '"
                + empleado.getApellido() + "')"
                + empleado.getExtension() + "', '"
                + empleado.getEmail() + "', '"
                + empleado.getIdOficina() + "')"
                + empleado.getIdeJefe() + "', '"
                + empleado.getPuesto() + "')";
        insertarModificarEliminarDataBase(sql);
    }


    public List<Empleado> listarTodosLosEmpleados() throws Exception {
        String sql = "SELECT id_empleado, codigo_empleado, nombre, apellido FROM empleado";
        consultarDataBase(sql);
        List<Empleado> empleados = new ArrayList<>();
        while (resultSet.next()) {
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(resultSet.getInt("id_empleado"));
            empleado.setCodigoEmpleado(resultSet.getInt("codigo_empleado"));
            empleado.setNombre(resultSet.getString("nombre"));
            empleado.setApellido(resultSet.getString("apellido"));
            empleados.add(empleado);
        }
        return empleados;
    }

    public void eliminarEmpleadoPorId(int id) throws Exception {
        String sql = "DELETE FROM empleado WHERE id_empleado = " + id;
        insertarModificarEliminarDataBase(sql);
    }
    
}
