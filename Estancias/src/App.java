//import java.security.Provider.Service;

//import Persistencia.DAOTest;
import Servicios.CasaServicio;
import Servicios.FamiliaServicio;

import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        CasaServicio casas = new CasaServicio();
        FamiliaServicio familias = new FamiliaServicio();

        /*
         * DAOTest daoTest = new DAOTest();
         * daoTest.probarConexion();
         */

        do {
            System.out.println("\nMenú de Consultas:");
            System.out.println("1. Listar familias con al menos 3 hijos menores de 10 años");
            System.out.println("2. Casas disponibles en Reino Unido en agosto 2020");
            System.out.println("3. Familias con email Hotmail");
            System.out.println("4. Casas disponibles a partir de una fecha por N días");
            System.out.println("5. Clientes con estancia y descripción de la casa");
            System.out.println("6. Estancias reservadas por un cliente con info de la casa");
            System.out.println("7. Incrementar precio por día en Reino Unido en 5%");
            System.out.println("8. Número de casas por país");
            System.out.println("9. Casas en Reino Unido con comentarios de 'limpias'");
            System.out.println("10. Insertar estancia verificando disponibilidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    familias.listarFamilias(3, 10);
                    break;
                case 2:
                    casas.listarCasasDisponibles("Reino Unido", "2020-08-01", "2020-08-31");
                    break;
                case 3:
                    familias.listarFamilias("hotmail");
                    break;
                case 4:
                casas.listarCasasDisponibles("2020-08-01", "3");
                    break;
                case 5:
                    // listarClientesYCasas();
                    break;
                case 6:
                    // listarEstanciasReservadasPorClientes();
                    break;
                case 7:
                    // incrementarPrecioCasasReinoUnido(5);
                    break;
                case 8:
                    // obtenerNumeroCasasPorPais();
                    break;
                case 9:
                    // listarCasasLimpiasReinoUnido();
                    break;
                case 10:
                    // insertarNuevaEstancia(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

}
