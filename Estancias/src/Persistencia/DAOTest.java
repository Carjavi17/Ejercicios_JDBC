package Persistencia;

public class DAOTest extends DAO {
    public void probarConexion() {
        try {
            connectarDataBase();
            System.out.println("Conexión exitosa.");
            desconectarDataBase();
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }
}
