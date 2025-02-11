package Servicios;

import java.sql.Date;
import java.util.List;
import Entidades.Casa;
import Persistencia.CasaDAO;

public class CasaServicio {

    private CasaDAO cd;
    
   public CasaServicio(){
        this.cd = new CasaDAO();
    }

    public Casa crearNuevaCasa(Integer idCasa, String calle, int numero, String codigoPostal, String ciudad,
            String pais, Date fechaDesde, Date fechaHasta, int tiempoMaximo, int tiempoMinimo, Double precioHabitacion,
            String tipoVivienda) throws Exception {

        validacionesCalleYNumero(calle, numero);
        Casa casa = new Casa(idCasa, calle, numero, codigoPostal, ciudad, pais, fechaDesde, fechaHasta,
        tiempoMaximo, tiempoMinimo, precioHabitacion, tipoVivienda);
        cd.guardarCasa(casa);
        return casa;
    }

    public void validacionesCalleYNumero(String calle, int numero) throws Exception {
        if (calle == null) {
            throw new Exception("El nombre de la calle no puede ser nulo.");
        }
        if (numero == 0) {
            throw new Exception("El numero de casa no puede ser cero.");
        }
    }

    public void obtenerTodasLasCasas() throws Exception {
        String query = "SELECT * FROM casas";

        List<Casa> listaCasas = cd.listarTodasLasCasas();

        for (Casa casa : listaCasas) {
            System.out.println("Calle: " + casa.getCalle() + ", Numero: " + casa.getNumero());
        }
    }

    public void listarCasasDisponibles(String pais, String fechaDesde , String fechaHasta) throws Exception{
        
        List<Casa> listaCasas = cd.listarTodasLasCasas(pais, fechaDesde, fechaHasta);
        int contador = 1;

        for (Casa casa : listaCasas) {
            System.out.println("Casa #"+ contador++ + " Calle: " + casa.getCalle() + ", Numero: " + casa.getNumero());
        }

    }

    public void listarCasasDisponibles(String fechaDesde, String dias) throws Exception{
        
        List<Casa> listaCasas = cd.listarTodasLasCasas(fechaDesde, dias);
        int contador = 1;

        for (Casa casa : listaCasas) {
            System.out.println("Casa #"+ contador++ + " Calle: " + casa.getCalle() + ", Numero: " + casa.getNumero());
        }

    }

    
}
